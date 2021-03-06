/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.slack.client.exceptions;

/**
 * Created by estebanwasinger on 1/4/15.
 */
public class ChannelNotFoundException extends RuntimeException {

    public ChannelNotFoundException(String msg) {
        super(msg);
    }

}

