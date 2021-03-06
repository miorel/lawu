/*
 * Copyright 2008-2009 Sun Microsystems, Inc.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Sun designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Sun in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * CA 95054 USA or visit www.sun.com if you need additional information or
 * have any questions.
 */

package java.dyn;

import java.security.*;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;

/**
 * This class is for runtime permissions. A RuntimePermission
 * contains a name (also referred to as a "target name") but
 * no actions list; you either have the named permission
 * or you don't.
 *
 * <P>
 * The target name is the name of the runtime permission (see below). The
 * naming convention follows the  hierarchical property naming convention.
 * Also, an asterisk
 * may appear at the end of the name, following a ".", or by itself, to
 * signify a wildcard match. For example: "loadLibrary.*" or "*" is valid,
 * "*loadLibrary" or "a*b" is not valid.
 * <P>
 * The following table lists all the possible RuntimePermission target names,
 * and for each provides a description of what the permission allows
 * and a discussion of the risks of granting code the permission.
 * <P>
 *
 * <table border=1 cellpadding=5 summary="permission target name,
 *  what the target allows,and associated risks">
 * <tr>
 * <th>Permission Target Name</th>
 * <th>What the Permission Allows</th>
 * <th>Risks of Allowing this Permission</th>
 * </tr>
 *
 * <tr>
 *   <td>registerBootstrapMethod.{class name}</td>
 *   <td>Specifying a bootstrap method for invokedynamic, within a class of the given name</td>
 *   <td>An attacker could attempt to attach a bootstrap method to a class which
 *       has just been loaded, thus gaining control of its invokedynamic calls.</td>
 * </tr>
 *
 * <tr>
 *   <td>invalidateAll</td>
 *   <td>Force the relinking of invokedynamic call sites everywhere.</td>
 *   <td>This could allow an attacker to slow down the system, or perhaps surface timing bugs in a dynamic language implementations, by forcing redundant relinking operations.</td>
 * </tr>
 *
 *
 * <tr>
 *   <td>invalidateCallerClass.{class name}</td>
 *   <td>Force the relinking of invokedynamic call sites in the given class.</td>
 *   <td>See {@code invalidateAll}.</td>
 * </tr>
 * </table>
 *
 * @see java.security.BasicPermission
 * @see java.lang.SecurityManager
 *
 * @author John Rose, JSR 292 EG
 */

public final class LinkagePermission extends BasicPermission {
    /**
     * Create a new LinkagePermission with the given name.
     * The name is the symbolic name of the LinkagePermission, such as
     * "registerBootstrapMethod", "invalidateCallerClass.*", etc. An asterisk
     * may appear at the end of the name, following a ".", or by itself, to
     * signify a wildcard match.
     *
     * @param name the name of the LinkagePermission
     */
    public LinkagePermission(String name) {
        super(name);
    }

    /**
     * Create a new LinkagePermission with the given name on the given class.
     * Equivalent to {@code LinkagePermission(name+"."+clazz.getName())}.
     *
     * @param name the name of the LinkagePermission
     * @param clazz the class affected by the permission
     */
    public LinkagePermission(String name, Class<?> clazz) {
        super(name + "." + clazz.getName());
    }
}
