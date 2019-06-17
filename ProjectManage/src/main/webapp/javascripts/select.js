dd.biz.contact.choose({
    multiple: true, //是否多选：true多选 false单选； 默认true
    users: ['10001', '10002', ...], //默认选中的用户列表，员工userid；成功回调中应包含该信息
corpId: 'ding4a5150e3de1ed89235c2f4657eb6378f', //企业id
    max: 10, //人数限制，当multiple为true才生效，可选范围1-1500
    onSuccess: function(data) {
    /* data结构
      [{
        "name": "张三", //姓名
        "avatar": "
http://g.alicdn.com/avatar/zhangsan.png
" //头像图片url，可能为空
        "emplId": '0573', //员工userid
       },
       ...
      ]
    */
},
onFail : function(err) {}
});