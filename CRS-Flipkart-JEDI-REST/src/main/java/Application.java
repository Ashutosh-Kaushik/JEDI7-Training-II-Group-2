import com.flipkart.restController.StudentRestAPI;
import com.flipkart.service.ApplicationResources;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class Application extends io.dropwizard.Application<ApplicationConfiguration> {
    public static void main(String[] args) throws Exception {
        new Application().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<ApplicationConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(ApplicationConfiguration configuration,
                    Environment environment) {
        final ApplicationResources resource = new ApplicationResources();
        environment.jersey().register(resource);
        final StudentRestAPI studentRestAPI=new StudentRestAPI();
        environment.jersey().register(studentRestAPI);
        // nothing to do yet
    }

}
