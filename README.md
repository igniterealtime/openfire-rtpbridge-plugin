# Openfire RTP Bridge Plugin

Relays UDP traffic (such as RTP) between two clients that are unable to connect to each other directly, for example because one or both of them are behind a NAT device or a strict firewall.

This functionality used to be part of Openfire, where it was known as the "Media Proxy". It was moved to this plugin in Openfire 5.2.0.

## A non-standard protocol

This plugin does not provide a generic media relay. Clients can only use it through the `http://www.jivesoftware.com/protocol/rtpbridge` protocol, which is not standardized: it was never published as a XEP (XMPP Extension Protocol). The only known clients that implement it are the legacy Jingle implementation in Smack (`smack-jingle-old`) and the Jingle plugin for Spark, which is no longer included in Spark releases.

Clients that use standardized mechanisms, such as TURN servers discovered through [XEP-0215: External Service Discovery](https://xmpp.org/extensions/xep-0215.html), cannot make use of this plugin.

## Configuration

The plugin is configured via the Openfire Admin Console. After installation, a new Admin Console page is available. The page can be found on a main menu in the "Server" tab, "Media Services" sub-tab. The name of the page is "RTP Bridge" (in versions of Openfire that included this functionality, the page was named "Media Proxy"). The service is disabled by default, and needs to be enabled on that page.

The plugin uses the same properties (`mediaproxy.*`) as the Media Proxy that used to be part of Openfire. Configuration made in earlier versions of Openfire therefore applies to this plugin.

## Reporting Issues

Issues may be reported to the [forums](https://discourse.igniterealtime.org) or via this repo's [Github Issues](https://github.com/igniterealtime/openfire-rtpbridge-plugin).
