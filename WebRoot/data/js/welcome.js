$(function(){
    var url = location.href.split('#')[0];//url不能写死
    $.ajax({
        type : "get",
        url : "jsSdk/getData",
        dataType : "json",//服务器返回的类型
        async : false,
        data:{url:url},
        success : function(data) {
        	data = data.data;
            wx.config({
                debug: true,////生产环境需要关闭debug模式
                appId: data.appid,//appId通过微信服务号后台查看
                timestamp: data.timestamp,//生成签名的时间戳
                nonceStr: data.noncestr,//生成签名的随机字符串
                signature: data.signature,//签名
                jsApiList: [//需要调用的JS接口列表
                    'checkJsApi',//判断当前客户端版本是否支持指定JS接口
                    'onMenuShareTimeline',//分享给好友
                    'onMenuShareAppMessage',//分享到朋友圈
                    'getLocation' //地址位置服务
                ]
            });
        },
        error: function(xhr, status, error) {
        	$("#id1").text(status);
            //alert(xhr.responseText);
        }
    })
});

wx.error(function(res){
    // config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
	 $("#id1").text(res.errMsg);
});

wx.ready(function () {
	 $("#id1").text("准备好了");
    var link = window.location.href;
    var protocol = window.location.protocol;
    var host = window.location.host;

    //getAddress();
   
});

function getAddress(){
	 $("#id1").text("执行啦==============");
	
	  wx.getLocation({  
		   type: 'wgs84', // 默认为wgs84的gps坐标，如果要返回直接给openLocation用的火星坐标，可传入'gcj02'  
		   success: function (res) {  
		       var latitude = res.latitude; // 纬度，浮点数，范围为90 ~ -90  
		       var longitude = res.longitude; // 经度，浮点数，范围为180 ~ -180。  
		       var speed = res.speed; // 速度，以米/每秒计  
		       var accuracy = res.accuracy; // 位置精度  
		       $("#id1").text(latitude + "  "+longitude);
		       getDom(latitude,longitude);
		   } ,
	  cancel: function (res) {
		  $("#id1").text(res.errMsg);
      },
      fail: function (res) {
    	  $("#id1").text(res.errMsg);
      }

		});  
}


function getDom(latitude,longitude){
	
	$("#id1").text("访问高德api");
	var url  = "http://restapi.amap.com/v3/geocode/regeo?output=JSON&location="+longitude+","+latitude+"&key=617cb553c0fdbd7304e0417042005493&radius=100&extensions=all";
	 $.ajax({
	        type : "get",
	        url : url,
	        dataType : "jsonp",//服务器返回的类型
	        async : false,
	        success : function(data) {
	        	$("#id1").text(data.regeocode.formatted_address);
	        },
	        error: function(xhr, status, error) {
	        	$("#id1").text("status="+status);
	        }
	    });
}

function showLocationDom(data){
	$("#id1").text(data.regeocode.formatted_address);
}