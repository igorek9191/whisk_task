package property_handling;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:general.properties")
public interface GeneralProperties extends Config {

    @Key("url")
    String url();

    @Key("loginName")
    String loginName();

    @Key("password")
    String password();

    @Key("uri")
    String uri();

    @Key("token")
    String token();

    @Key("list.post")
    String listPost();

    @Key("list.get")
    String listGet();

    @Key("list.delete")
    String listDelete();
}
