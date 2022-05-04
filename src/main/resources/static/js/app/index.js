var main = {
    init : function() {
            var _this = this;

            $('.btn-invenCheck').on('click', function () {
                _this.invenCheck();
            });

    },
    invenCheck : function () { //재고조회 클릭 이벤트
        var no = $('.shoesNo').val();
        var size = $('input[name=sizeRadio]:checked').val();
        $('.size').text(size);
        var data = {
            shoesNo: no,
            shoesSize: size
        };
        console.log(data);

        $.ajax({ // shoesNo + shoesSize json문자열로 컨트롤러에 넘기기
              type: 'POST',
              url: '/api/invenSearch',
              dataType: 'json',
              contentType: 'application/json; charset=utf-8',
              data: JSON.stringify(data)
          }).done(function(list) {
              $(".shipping-body").empty();
              console.log(list);
              for(var i=0;i<list.length;i++)
                storeList(list[i]);
          }).fail(function (error) {
              alert(JSON.stringify(error));
          });
    }

};
main.init();

function storeList(list) {
    var str = '';
    str += '<div class="shipping-list">';
    str += '<div class="column column-addr">';
    str += '<h2 class="tit">'+list.storeName+'</h2>';
    str += '<dl class="address-wrap">';
    str += '<dt class="addr-type">도로명</dt>';
    str += '<dd class="addr">'+list.storeLocation+'</dd>';
    str += '<dt class="addr-type">연락처</dt>';
    str += '<dd class="addr" style="color:#288756;">'+list.storeNumber+'</dd>';
    str += '</dl>';
    str += '</div>';
    str += '<div class="column column-reserve">';
    str += '<span class="quantity">'+list.invenQuantity+'</span>';
    str += '</div>';
    str += '</div>';

    $(".shipping-body").append(str);
}
