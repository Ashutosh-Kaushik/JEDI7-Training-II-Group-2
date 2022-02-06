import com.flipkart.restController.ProfessorRestAPI;
import com.flipkart.restController.StudentRestAPI;
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
        final StudentRestAPI studentRestAPI=new StudentRestAPI() ;
        environment.jersey().register(studentRestAPI);
        final ProfessorRestAPI professorRestAPI = new ProfessorRestAPI();
        environment.jersey().register(professorRestAPI);
        // nothing to do yet
    }

}
