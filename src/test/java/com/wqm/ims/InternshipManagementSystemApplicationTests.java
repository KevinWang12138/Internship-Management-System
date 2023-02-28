package com.wqm.ims;

import com.wqm.ims.common.CommonFunction;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InternshipManagementSystemApplicationTests {

	@Test
	void contextLoads() {
		System.out.println(CommonFunction.phoneVerification("18302426666"));
	}

}
