/**
 * Created by zhangxd on 2016/7/6.
 * 获取Metadata 里面 channel
 */
//cordova-plugin-channel.Channel为插件id，要跟cordova_plugins.js中的id一致
cordova.define("cordova-plugin-channel.Channel",   function(require, exports, module){
    var exec = require("cordova/exec");
    module.exports = {
        getChannel: function(onSuccess, onError){
            //参数1：成功回调function
            //参数2：失败回调function
            //参数3：feature name，与config.xml中注册的一致
            //参数4：要传递的参数，json格式
            exec(onSuccess, onError,"Channel","getChannel",[]);
        }
    }
});