package com.wqm.ims;

import com.wqm.ims.common.CommonFunction;
import com.wqm.ims.common.request.info.SetBasicInfoRequest;
import com.wqm.ims.service.info.StudentInfoService;
import com.wqm.ims.service.login.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InternshipManagementSystemApplicationTests {

	@Test
	void contextLoads() {
		System.out.println(CommonFunction.phoneVerification("18302426666"));
	}

	@Autowired
	LoginService loginService;

	@Autowired
	StudentInfoService studentInfoService;

	@Test
	void testDB(){
		studentInfoService.SetBasicInternshipInfo("18302429555",new SetBasicInfoRequest(null,"美团","2029-07-18","2029-09-20","","",0));
	}


}
