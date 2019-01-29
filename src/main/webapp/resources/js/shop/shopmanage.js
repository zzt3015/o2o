$(function(){
	var shopId = getQueryString('shopId');
	var shopInforUrl = '/o2o/shop/getShopById?shopId=' + shopId;
	$.getJSON(shopInforUrl,function(data){
		if(data.redirect){
			window.loacation.href = data.url;
		}else{
			if(data.shopId != null && data.shopId != undefined){
				shopId = data.shopId;
			}
		}
		
		$('#shopInfo').attr('href','/ofo/shop/shopoperation?shopId=' + shopId);
		
	})
	
	
	
})


