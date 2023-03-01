package com.wqm.ims;

import com.wqm.ims.common.CommonFunction;
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

	@Test
	void testDB(){
		loginService.login("18302429555","123",0);
	}

}
