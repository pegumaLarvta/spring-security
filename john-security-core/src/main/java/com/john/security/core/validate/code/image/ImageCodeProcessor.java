package com.john.security.core.validate.code.image;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import com.john.security.core.validate.code.impl.AbstractValidateCodeProcessor;

/**
 * ͼƬ��֤�봦����
* @author ���� john
* @version ����ʱ�䣺2019��5��6�� ����6:02:09
*/
@Component("imageValidateCodeProcessor")
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {

	/**
	 * ����ͼ����֤�룬����д����Ӧ��
	 */
	@Override
	protected void send(ServletWebRequest request, ImageCode imageCode) throws Exception {
		ImageIO.write(imageCode.getImage(), "JPEG", request.getResponse().getOutputStream());
	}

}
