/*
 * Copyright (C) 2026 Ignite Realtime Foundation. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jivesoftware.openfire.mediaproxy;

import org.jivesoftware.openfire.XMPPServer;
import org.jivesoftware.openfire.container.Plugin;
import org.jivesoftware.openfire.container.PluginManager;

import java.io.File;

/**
 * Openfire plugin that runs the {@link MediaProxyService}, which implements the non-standard
 * 'http://www.jivesoftware.com/protocol/rtpbridge' protocol.
 */
public class RTPBridgePlugin implements Plugin
{
    private static RTPBridgePlugin instance;

    private MediaProxyService mediaProxyService;

    /**
     * Returns the instance of this plugin that is currently loaded.
     *
     * @return the plugin instance, or null when the plugin is not loaded.
     */
    public static RTPBridgePlugin getInstance()
    {
        return instance;
    }

    @Override
    public void initializePlugin(final PluginManager manager, final File pluginDirectory)
    {
        mediaProxyService = new MediaProxyService();
        mediaProxyService.initialize(XMPPServer.getInstance());
        mediaProxyService.start();
        instance = this;
    }

    @Override
    public void destroyPlugin()
    {
        instance = null;
        if (mediaProxyService != null) {
            mediaProxyService.stop();
            mediaProxyService.destroy();
            mediaProxyService = null;
        }
    }

    /**
     * Returns the media proxy service that is run by this plugin.
     *
     * @return the media proxy service.
     */
    public MediaProxyService getMediaProxyService()
    {
        return mediaProxyService;
    }
}
