package api.settings;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class TraceUnitExtension implements AfterEachCallback, BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context){
        System.out.println("Запустился тест : " + context.getDisplayName());
            }

    @Override
    public void afterEach(ExtensionContext context){
        System.out.println("Завершился тест : " + context.getDisplayName());
    }


}
