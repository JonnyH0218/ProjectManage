/**
 * Created by liqiao on 8/10/15.
 */

/**
 * _config comes from server-side template. see views/index.jade
 */
/*
dd.config({
	agentId : _config.agentId,
	corpId : _config.corpId,
	timeStamp : _config.timeStamp,
	nonceStr : _config.nonceStr,
	signature : _config.signature,
	jsApiList : [ 'runtime.info', 'biz.contact.choose',
		'device.notification.confirm', 'device.notification.alert',
		'device.notification.prompt', 'biz.ding.post',
		'biz.util.openLink' ]
});


dd.ready(function() {
	dd.biz.navigation.setTitle({
		title: '钉钉demo',
		onSuccess: function(data) {
		},
		onFail: function(err) {
			log.e(JSON.stringify(err));
		}
	});
	alert('dd.ready rocks!');

	dd.runtime.info({
		onSuccess : function(info) {
			logger.e('runtime info: ' + JSON.stringify(info));
		},
		onFail : function(err) {
			logger.e('fail: ' + JSON.stringify(err));
		}
	});
	dd.ui.pullToRefresh.enable({
		onSuccess: function() {
		},
		onFail: function() {
		}
	})

	dd.runtime.permission.requestAuthCode({
		corpId : _config.corpId,
		onSuccess : function(info) {
			alert('authcode: ' + info.code);
			$.ajax({
				url : 'getUserInfo?code=' + info.code + '&corpid='
					+ _config.corpId,
				type : 'GET',
				success : function(data, status, xhr) {
					alert(data);
					var info = JSON.parse(data);

					document.getElementById("userName").innerHTML = info.name;
					document.getElementById("userId").innerHTML = info.userid;

					// 图片
					if(info.avatar.length != 0){
						var img = document.getElementById("userImg");
						img.src = info.avatar;
						img.height = '100';
						img.width = '100';
					}

				},
				error : function(xhr, errorType, error) {
					logger.e("yinyien:" + _config.corpId);
					alert(errorType + ', ' + error);
				}
			});

		},
		onFail : function(err) {
			alert('fail: ' + JSON.stringify(err));
		}
	});
});

dd.error(function(err) {
	alert('dd error: ' + JSON.stringify(err));
});*/
dd.ready(function() {
	dd.runtime.permission.requestAuthCode({
		corpId: 'ding4a5150e3de1ed89235c2f4657eb6378f', // 企业id
		onSuccess: function (info) {
			code = info.code // 通过该免登授权码可以获取用户身份
			alert(code);
			$.ajax({
				url : 'login?code=' + info.code,
				type : 'GET'
			});
		}});
});