package com.detection.util.api;

import com.aliyun.dysmsapi20170525.models.*;
import com.aliyun.teaopenapi.models.Config;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.detection.util.PropertiesUtil;

/**
 * @Author ding
 * @Date 2021/12/10
 */
public class AliYunAPI {


    public static com.aliyun.dysmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                // 您的AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new com.aliyun.dysmsapi20170525.Client(config);
    }

    /**
     * 创建短信模板
     * */
    public static AddSmsTemplateResponse createTemplate() throws Exception {
        com.aliyun.dysmsapi20170525.Client client = AliYunAPI.createClient(PropertiesUtil.getKey("ACCESS_KEY_ID"), PropertiesUtil.getKey("ACCESS_KEY_SECRET"));
        AddSmsTemplateRequest addSmsTemplateRequest = new AddSmsTemplateRequest()
                .setTemplateType(0)//   0：是验证码 1：短信...
                .setTemplateName("test")  // 模板名称
                .setTemplateContent("how are you")//短信内容
                .setRemark("测试");//审核说明
        return client.addSmsTemplate(addSmsTemplateRequest);
    }

    /**
     * 发送短信
     * */
     public static void sendMessage(){
         DefaultProfile profile = DefaultProfile.getProfile("cn-qingdao", PropertiesUtil.getKey("ACCESS_KEY_ID"), PropertiesUtil.getKey("ACCESS_KEY_SECRET"));
         IAcsClient client = new DefaultAcsClient(profile);

         CommonRequest request = new CommonRequest();
         request.setSysMethod(MethodType.POST);
         request.setSysDomain("dysmsapi.aliyuncs.com");
         request.setSysVersion("2017-05-25");
         request.setSysAction("SendSms");
         request.putQueryParameter("PhoneNumbers", "17621250373");
         request.putQueryParameter("SignName", "test");
         request.putQueryParameter("TemplateCode", "SMS_229642252");
         request.putQueryParameter("TemplateParam", "{\"name\":\"张三\",\"message\":\"hello\"}");
         try {
             CommonResponse response = client.getCommonResponse(request);
             System.out.println(response.getData());
         } catch (ServerException e) {
             e.printStackTrace();
         } catch (ClientException e) {
             e.printStackTrace();
         }
     }
    /**
     * 创建短信签名
     * */
    public static ModifySmsSignResponse createSignature() throws Exception {
        com.aliyun.dysmsapi20170525.Client client = AliYunAPI.createClient(PropertiesUtil.getKey("ACCESS_KEY_ID"), PropertiesUtil.getKey("ACCESS_KEY_SECRET"));

        ModifySmsSignRequest modifySmsSignRequest = new ModifySmsSignRequest()
                .setSignName("ding")
                .setSignSource(0)
                .setRemark("测试");
        return client.modifySmsSign(modifySmsSignRequest);
    }


    public static void main(String[] args_){
//        AddSmsTemplateResponseBody body = createTemplate().getBody();
//
//        System.out.println(body.getCode());
//        System.out.println(body.getTemplateCode());
//        System.out.println(body.getMessage());
//        ModifySmsSignResponseBody body = createSignature().getBody();
//        System.out.println(body.getCode());
//        System.out.println(body.getSignName());
//        createTemplate();
//          sendMessage();

    }
}

