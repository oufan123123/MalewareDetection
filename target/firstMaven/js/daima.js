
var filepath = $("body").attr("filepath");

var checkedarray = [];
var nthTabs;
var setting = { // 此处根据自己需要进行配置
	data : {
		simpleData : {
			enable : true, // 简单数据模式
			idKey : "id",
			pIdKey : "parentId",
			rootPId : 0
		}
	},
	check : {
		enable : false,
		chkStyle : "radio",
		radioType : "all"
	},
	view : {
		dblClickExpand : true,
		selectedMulti : false
	},
	callback : {
		onClick : zTreeOnClick,
		onCheck : zTreeOnCheck
	}
};
function zTreeOnCheck(event, treeId, treeNode) {
	if (treeNode.checked) {

		checkedarray.push(treeId);
	} else {

		var index = checkedarray.indexOf(treeId);
		if (index > -1) {
			checkedarray.splice(index, 1);
		}

	}
};
function zTreeOnClick(event, treeId, treeNode) {
	if (treeNode.isParent) {

		return;

	} else {

		$.ajax({
			type : "Get",
			url : "refactory/getFilecontent", // ajax请求地址
			data : {
				"path" : treeNode.path
			},
			success : function(data) {
			   
				var content = '<pre class="brush: c;toolbar:false;quick-code:false">';
				for (var i = 0; i < data.data.length; i++) {
                    content += data.data[i].content +" &#10;";// 添加option
					/*if (n.length>0&&n.contain(data.data[i].line)) {

=======
					if (line!=""&&data.data[i].line==line) {

						var pre = $("#nth-tab-" + id + " pre");

						var code = $("#nth-tab-" + id + " code");
						var length = code[0].clientHeight || code[0].offsetHeight;

						pre.scrollTop(length * line);
>>>>>>> .merge-right.r21
						content += "<code class='single-row '>"
							+"<span style='background-color:red'>"+ data.data[i].content +"</span>"+ "</code><br>";// 添加option
					} else {
						content += "<code class='single-row '>"
							+"<span>"+ data.data[i].content +"</span>"+ "</code><br>";// 添加option
					}*/

				}
				content = content + "</pre>";

				var id = Math.ceil(Math.random() * 1000);

				nthTabs.addTab({
					id : "nth-tab-" + id,
					title : treeNode.name,
					content : content,
					active : true,
					allowClose : true,
					location : true,
					fadeIn : false
				});
				$(".nav-tabs").children('.active')
						.attr("title", treeNode.rpath);
                SyntaxHighlighter.highlight();
                var tab= $("#nth-tab-"+id+" .nth-tabs-content");
                tab.height(document.body.clientHeight-100);
              
               
               /* var code = $("#nth-tab-"+id+" code");
                var scroll= $("#nth-tab-"+id+" .nth-tabs-content");
                var length = code[0].clientHeight || code[0].offsetHeight;
                console.log(code[0].clientHeight|| code[0].offsetHeight);
*/
               /* $("#nth-tab-"+id+" .nth-tabs-content").animate({
                    scrollTop:scroll_offset.top //让body的scrollTop等于pos的top，就实现了滚动
                })*/
               /* scroll.scrollTop(length * 40);*/
				/*
				 * alert(pre.height());
				 * alert(code[1].clientHeight||code[1].offsetHeight);
				 * alert(code.length);
				 */

				/* var pre = (code[0].scrollHeight - code.height()) / 2; */
				/* code[0].scrollTop =code.height() ; */
                /*$('pre code').each(function(i, e) {hljs.highlightBlock(e)});*/

			},

		});

		/* alert(treeNode.id + ", " + treeNode.name+", " + treeNode.path); */
	}

}
$(function() {
	$.fn.zTree.destroy();

					/*
					 * if (nodes.length>0&&nodes[0].parentId!=0) { var
					 * node=treeObj.getNodesByParam("id",nodes[0].parentId,
					 * null); console.log(node); treeObj.expandNode(node[0],
					 * true, false, false); } console.log(nodes);
					 */
    inte(filepath);



	nthTabs = $("#main-tabs").nthTabs();


});

// 递归展开父节点
var f = function(id, parentId) {

	var treeObj = $.fn.zTree.getZTreeObj("treeDemo_" + id);
	if (parentId != 0) {
		var node = treeObj.getNodesByParam("id", parentId, null);
		treeObj.expandNode(node[0], true, false, false);
		return f(id, node[0].parentId);
	}
};


function inte(path){

	if (filepath=="") {

		return;

	}else{

		$.ajax({
			type : "Get",
			url : "refactory/getTree", // ajax请求地址
			data : {
				path : path
			},
			success : function(data) {

				var ztree = $("#ztree");
				var id = Math.ceil(Math.random() * 1000);
				var ul = " <ul id='treeDemo_" + id
						+ "' class='ztree' ></ul>";
				ztree.append(ul);
				$.fn.zTree.init($("#treeDemo_" + id), setting, data); // 加载数据

				
				/* $("#"+nodes[0].tId+"_a").click(); */
		


	}

		})
}
}



