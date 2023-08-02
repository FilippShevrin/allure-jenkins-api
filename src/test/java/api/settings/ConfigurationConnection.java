package api.settings;

import org.aeonbits.owner.Config;

    @Config.Sources({"classpath:config/Svodka.properties"})
    public interface ConfigurationConnection extends Config {

        //Настройки апи соединения

        @Key("https://reqres.in/")
        String urlReqres();

        @Key("https://catfact.ninja/fact")
        String urlCatFacts();

        @Key("http://85.192.34.140:8080/v2/api-docs")
        String urlSwaggerTrain();
}
