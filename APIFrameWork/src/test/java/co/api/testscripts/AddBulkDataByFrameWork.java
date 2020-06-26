package co.api.testscripts;

import org.testng.annotations.Test;
import com.api.genericlib.BaseClass;
import io.restassured.response.Response;

public class AddBulkDataByFrameWork extends BaseClass
{
	@Test
	public void checkBulkDataByFW() throws Exception
	{
		String apiTestData = config.getApiTestData("addBulkData");
		Response resp = config.excuteBulkPostRequest(apiTestData);
		rutil.ValidateStatusCode(resp, 201);
		rutil.ValidateContentType(resp);
		resp.then().log().all();
	}
}
