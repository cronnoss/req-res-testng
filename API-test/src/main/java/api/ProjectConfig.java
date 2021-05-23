package api;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config.properties"})
public interface ProjectConfig extends Config {

    @Key("baseURI")
    String baseURI();

    @DefaultValue("en")
    String locale();

    @Key("logging")
    Boolean logging();

    @Key("pageNumber")
    String pageNumber();

    @Key("name")
    String name();

    @Key("job")
    String job();
}