/*******************************************************************************
 * Copyright (c) 2012, 2015  Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 *
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *  - rbarkhouse - 08 February 2012 - 2.3.3 - Initial implementation
 ******************************************************************************/
package org.eclipse.persistence.testing.jaxb.sun.charescape;

import java.io.IOException;
import java.io.Writer;

public abstract class AbstractNonELCharacterEscapeHandler implements com.sun.xml.bind.marshaller.CharacterEscapeHandler {

    public void escape(char[] buf, int start, int len, boolean isAttValue, Writer out) throws IOException {
        return;
    }

}
