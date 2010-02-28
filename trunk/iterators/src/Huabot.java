import static com.googlecode.lawu.net.irc.IrcCommands.join;
import static com.googlecode.lawu.net.irc.IrcCommands.kick;
import static com.googlecode.lawu.net.irc.IrcCommands.privmsg;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Locale;

import com.googlecode.lawu.net.ClientsThread;
import com.googlecode.lawu.net.event.AbstractNetworkEventListener;
import com.googlecode.lawu.net.event.ReadingEvent;
import com.googlecode.lawu.net.irc.IrcClient;
import com.googlecode.lawu.net.irc.cmd.JoinCommand;
import com.googlecode.lawu.net.irc.cmd.PrivmsgCommand;
import com.googlecode.lawu.net.irc.event.AbstractIrcEventListener;
import com.googlecode.lawu.net.irc.event.IrcEvent;
import com.googlecode.lawu.net.log.NetworkLogger;

public class Huabot {
	@SuppressWarnings("null")
	public static void main(String[] arg) {
		final String channel = arg[0];
		final String nick = "huabot";
		ClientsThread thread = null;
		try {
			thread = new ClientsThread();
		}
		catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		final IrcClient client = new IrcClient(new InetSocketAddress("irc.freenode.net", 6667), thread);
		try {
			client.start();
		}
		catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		client.setDesiredNick(nick);
		client.setUserName(nick);
		client.addNetworkEventListener(new NetworkLogger(System.out));
		client.addNetworkEventListener(new AbstractNetworkEventListener() {
			@Override
			public void reading(ReadingEvent event) {
				String line = event.getMessage();
				if(line.matches("\\S+ 376 .*"))
					join(client, "#" + channel);
			}
		});
		client.addIrcEventListener(new AbstractIrcEventListener() {
			@Override
			public void joinEvent(IrcEvent<JoinCommand> event) {
				IrcClient client = event.getClient();
				JoinCommand cmd = event.getCommand();
				if(cmd.getChannel().toLowerCase(Locale.ENGLISH).equals("#" + channel)) {
					String user = event.getOrigin().getNick();
					if(!nick.toLowerCase(Locale.ENGLISH).equals(user))
						privmsg(client, "#" + channel, "Welcome to #" + channel + ", " + user + "!");
				}
			}
			
			@Override
			public void privmsgEvent(IrcEvent<PrivmsgCommand> event) {
				IrcClient client = event.getClient();
				PrivmsgCommand cmd = event.getCommand();
				if(cmd.getTarget().toLowerCase(Locale.ENGLISH).equals("#" + channel)) {
					String[] words = cmd.getMessage().trim().toLowerCase(Locale.ENGLISH).split("\\s+");
					if(words[0].equals("~help"))
						privmsg(client, "#" + channel, "my commands are: version, farmville");
					else if(words[0].equals("~version"))
						privmsg(client, "#" + channel, "this is huabot version 0.1");
					else if(words[0].equals("~farmville"))
						kick(client, "#" + channel, event.getOrigin().getNick(), "FARMVILLE'D");
				}
			}
		});
		thread.start();
	}
}
