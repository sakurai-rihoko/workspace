//# sourceMappingURL=page.js.map
var j=jQuery.noConflict();j.fn.extend({initPage:function(d,a,c){var b=j(this).attr("maxshowpageitem");null!=b&&0<b&&""!=b&&(page.maxshowpageitem=b);b=j(this).attr("pagelistcount");null!=b&&0<b&&""!=b&&(page.pagelistcount=b);b=j(this).attr("id");page.pageId=b;0>d&&(d=0);0>=a&&(a=1);page.setPageListCount(b,d,a,c)}});
var page={maxshowpageitem:5,pagelistcount:10,initWithUl:function(d,a,c){var b=1;0<a&&(b=0<a%page.pagelistcount?parseInt(a/page.pagelistcount)+1:parseInt(a/page.pagelistcount));a=page.getPageListModel(b,c);j("#"+d).html(a)},setPageListCount:function(d,a,c,b){a=parseInt(a);c=parseInt(c);page.initWithUl(d,a,c);page.initPageEvent(d,a,b);"function"==typeof b&&b(c)},initPageEvent:function(d,a,c){j("#"+d+">li[class='pageItem']").on("click",function(){page.setPageListCount(d,a,j(this).attr("page-data"),c)})},
getPageListModel:function(d,a){var c=a-1,b=a+1,e="pageItem",g="pageItem";0>=c&&(e="pageItemDisable");b>d&&(g="pageItemDisable");c=""+("<li class='"+e+"' data-count='1'  page-data='1' page-rel='firstpage'>\u9996\u9875</li>")+("<li class='"+e+"' data-count='"+c+"' page-data='"+c+"' page-rel='prepage'>\u4e0a\u4e00\u9875</li>");e=1;0<a-parseInt(page.maxshowpageitem/2)&&a+parseInt(page.maxshowpageitem/2)<=d?e=a-parseInt(page.maxshowpageitem/2):0<a-parseInt(page.maxshowpageitem/2)&&a+parseInt(page.maxshowpageitem/
2)>d&&(e=d-page.maxshowpageitem+1,0>=e&&(e=1));var h=parseInt(page.maxshowpageitem);d<h&&(h=d);for(var k=0;k<h;k++){var f=e++,l="pageItem";f==a&&(l="pageItemActive");c+="<li class='"+l+"' data-count='"+f+"' page-data='"+f+"' page-rel='itempage'>"+f+"</li>"}c+="<li class='"+g+"'  data-count='"+b+"' page-data='"+b+"' page-rel='nextpage'>\u4e0b\u4e00\u9875</li>";return c+="<li class='"+g+"'  data-count='"+d+"' page-data='"+d+"' page-rel='lastpage'>\u5c3e\u9875</li>"}};