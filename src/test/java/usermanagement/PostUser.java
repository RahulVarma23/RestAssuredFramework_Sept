package usermanagement;

import common.BaseRequest;
import configs.RequestPaths;
import configs.RequestSpecs;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import pojo.models.UserDto;
import java.util.ArrayList;

public class PostUser extends BaseRequest {


    @Test
    public void createUser () {
        RequestSpecification requestSpecification = RequestSpecs.buildCommonPetRequestSpec()
                .basePath(RequestPaths.USER_CREATE_WITH_ARRAY);

        ArrayList <Object> list = new ArrayList<>();
        for(int i=1;i<=10;i++) {
            UserDto userDto = UserDto.defaultUserBuilder().build();
            list.add(userDto);
        }

        Response response = sendPostRequest(requestSpecification, list);
    }
}
