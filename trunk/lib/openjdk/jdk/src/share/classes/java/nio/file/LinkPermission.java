/*
 * Copyright 2007-2009 Sun Microsystems, Inc.  All Rights Reserved.
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

package java.nio.file;

import java.security.BasicPermission;

/**
 * The {@code Permission} class for link creation operations.
 *
 * <p> The following table provides a summary description of what the permission
 * allows, and discusses the risks of granting code the permission.
 *
 * <table border=1 cellpadding=5
 *        summary="Table shows permission target name, what the permission allows, and associated risks">
 * <tr>
 * <th>Permission Target Name</th>
 * <th>What the Permission Allows</th>
 * <th>Risks of Allowing this Permission</th>
 * </tr>
 * <tr>
 *   <td>hard</td>
 *   <td> Ability to add an existing file to a directory. This is sometimes
 *   known as creating a link, or hard link. </td>
 *   <td> Extreme care should be taken when granting this permission. It allows
 *   linking to any file or directory in the file system thus allowing the
 *   attacker access to all files. </td>
 * </tr>
 * <tr>
 *   <td>symbolic</td>
 *   <td> Ability to create symbolic links. </td>
 *   <td> Extreme care should be taken when granting this permission. It allows
 *   linking to any file or directory in the file system thus allowing the
 *   attacker to access to all files. </td>
 * </tr>
 * </table>
 *
 * @since 1.7
 *
 * @see Path#createLink
 * @see Path#createSymbolicLink
 */
public final class LinkPermission extends BasicPermission {
    static final long serialVersionUID = -1441492453772213220L;

    private void checkName(String name) {
        if (!name.equals("hard") && !name.equals("symbolic")) {
            throw new IllegalArgumentException("name: " + name);
        }
    }

    /**
     * Constructs a {@code LinkPermission} with the specified name.
     *
     * @param   name
     *          the name of the permission. It must be "hard" or "symbolic".
     *
     * @throws  IllegalArgumentException
     *          if name is empty or invalid
     */
    public LinkPermission(String name) {
        super(name);
        checkName(name);
    }

    /**
     * Constructs a {@code LinkPermission} with the specified name.
     *
     * @param   name
     *          the name of the permission; must be "hard" or "symbolic".
     * @param   actions
     *          the actions for the permission; must be the empty string or
     *          {@code null}
     *
     * @throws  IllegalArgumentException
     *          if name is empty or invalid, or actions is a non-empty string
     */
    public LinkPermission(String name, String actions) {
        super(name);
        checkName(name);
        if (actions != null && actions.length() > 0) {
            throw new IllegalArgumentException("actions: " + actions);
        }
    }
}
