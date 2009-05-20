/*
 * lawu
 * Copyright (C) 2009 Miorel-Lucian Palii
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 */
package lawu.chem.pdb.records;

public class Turn {
// COLUMNS      DATA TYPE        FIELD         DEFINITION
// --------------------------------------------------------------------
//  1 -  6      Record name      "TURN "
//  8 - 10      Integer          seq           Turn number; starts with 1 and
//                                             increments by one.
// 12 - 14      LString(3)       turnId        Turn identifier
// 16 - 18      Residue name     initResName   Residue name of initial residue in
//                                             turn.
// 20           Character        initChainId   Chain identifier for the chain
//                                             containing this turn.
// 21 - 24      Integer          initSeqNum    Sequence number of initial residue
//                                             in turn.
// 25           AChar            initICode     Insertion code of initial residue 
//                                             in turn.
// 27 - 29      Residue name     endResName    Residue name of terminal residue 
//                                             of turn.
// 31           Character        endChainId    Chain identifier for the chain
//                                             containing this turn.
// 32 - 35      Integer          endSeqNum     Sequence number of terminal 
//                                             residue of turn.
// 36           AChar            endICode      Insertion code of terminal residue
//                                             of turn.
// 41 - 70      String           comment       Associated comment.
	public Turn() {
	}

	@Override	
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if(o instanceof Turn) {
			Turn r = (Turn) o;
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
