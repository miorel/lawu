package lawu.doclets.formats.html;

import lawu.doclets.internal.toolkit.util.links.LinkOutput;

/**
 * Stores output of a link.
 *
 * @author Jamie Ho
 * @since 1.5
 */
public class LinkOutputImpl implements LinkOutput {    
    /**
     * The output of the link.
     */
    private StringBuilder output;
    
    /**
     * Construct a new LinkOutputImpl.
     */
    public LinkOutputImpl() {
        this.output = new StringBuilder();
    }
    
    /**
     * {@inheritDoc}
     */
    public void append(Object o) {
        this.output.append(o.toString()); 
    }
    
    @Override
	public String toString() {
        return this.output.toString();
    }    
}
