package com.john.security.core.validate.code;

import com.john.security.core.properties.SecurityConstants;

/**
* @author ���� john
* @version ����ʱ�䣺2019��5��11�� ����12:50:28
*/
public enum ValidateCodeType {
	
	/**
	 * ������֤��
	 */
	SMS {
		@Override
		public String getParamNameOnValidate() {
			return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_SMS;
		}
	},
	/**
	 * ͼƬ��֤��
	 */
	IMAGE {
		@Override
		public String getParamNameOnValidate() {
			return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
		}
	};

	/**
	 * У��ʱ�������л�ȡ�Ĳ���������
	 * @return
	 */
	public abstract String getParamNameOnValidate();

}
