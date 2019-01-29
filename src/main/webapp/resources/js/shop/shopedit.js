/**
 * 
 */
$(function(){
	
	var shopId = getQueryString('shopId');
	var isEdit = shopId ? true:false;
	var initUrl = '/o2o/shop/selectshop';
	var registShopUrl = '/o2o/shop/registershop';
	var shopInfoUrl = '/o2o/shop/getShopById?shopId=' + shopId;
	var editShopUrl =  '/o2o/shop/modifyshop';
/*	getInfo();*/
	if(isEdit){
		getShopInfo(shopId);
	}else{
		getCategory();
	}
	
	function getShopInfo(shopId){
		$.getJSON(shopInfoUrl, function(data) {
			if (data.success) {
				console.log(data.success);
				var shop = data.shop;
				$('#shop-name').val(shop.shopName);
				$('#shop-addr').val(shop.shopAddr);
				$('#shop-phone').val(shop.phone);
				$('#shop-desc').val(shop.shopDesc);
				var shopCategory = '<option data-id="'
						+ shop.shopCategory.shopCategoryId + '" selected>'
						+ shop.shopCategory.shopCategoryName + '</option>';
				var tempAreaHtml = '';
				data.areaList.map(function(item, index) {
					tempAreaHtml += '<option data-id="' + item.areaId + '">'
							+ item.areaName + '</option>';
				});
				$('#shop-category').html(shopCategory);
				$('#shop-category').attr('disabled','disabled');
				$('#area').html(tempAreaHtml);
				/*$('#area').attr('data-id',shop.areaId);*/
				$("#area option[data-id='"+shop.area.areaId+"']").attr("selected","selected");
			}
		});
	}
	
	function getCategory(){
		$.getJSON(initUrl,function(data){
			if(data.success){
				var tempHtml ='';
				var tempAreaHtml = '';
				data.shopCategoryList.map(function(item,index){
					tempHtml = '<option data-id="'+ item.shopCategoryId +
					'">' + item.shopCategoryName + '</option>';
					console.log(tempHtml);
				});
				data.areaList.map(function(item,index){
					tempAreaHtml = '<option data-id = "' + item.areaId + '">' + item.areaName + '</option>';
				});
				$('#shop-category').html(tempHtml);
				$('#shop-category').removeAttr('disabled');
				$('#area').html(tempAreaHtml);
			}
		});
		
		$('#submit').click(function(){
			var shop = {};
			shop.shopName = $('#shop-name').val();
			shop.shopAddr = $('#shop-addr').val();
			shop.phone = $('#shop-phone').val();
			shop.shopDesc = $('#shop-desc').val();
			
			if(isEdit){
				shop.shopId = shopId;
			}
			
			var VerifyCodeActual = $('#j_captcha').val();
			if(!VerifyCodeActual){
				$.toast("请输入验证码");
				return;
			}
			shop.shopCategory = {
					shopCategoryId:$('#shop-category').find('option').not(function(){
						return !this.selected;
					}).data('id')
			};
			
			shop.area = {
					areaId:$('#area').find('option').not(function(){
						return !this.selected;
					}).data('id')
			};
			var shopImg = $('#shop-img')[0].files[0];
			var formData = new FormData();
			formData.append('shopImg', shopImg);
			formData.append('shopStr', JSON.stringify(shop));
			formData.append('VerifyCodeActual',JSON.stringify(VerifyCodeActual));
			$.ajax({
				url : (isEdit?editShopUrl:registShopUrl),
				type : 'post',
				data : formData,
				contentType : false,
				processData : false,
				cache:false,
				success : function(data){
					if(data.success){
						$.totast('提交成功');
						console.log(data.VerifyCodeActual);
					}else{
						$.totast("false"+data.errMsg);
					}
				}
			});
			
			
		})
	}
	
	
	
	
})