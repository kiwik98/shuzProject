var main = {
    init : function() {
            var _this = this;

            //위시리스트 버튼 클릭 이벤트
            $('.wishIcon').on('click', function () {
                //_this.wishListAdd();
                console.log("위시리스트버튼");
                $(this).toggleClass("add");
                if($(this).hasClass("add")) {
                    $(".wishIcon").attr("src", "/img/icon/heart2.png");
                }else{
                    $(".wishIcon").attr("src", "/img/icon/heart1.png");
                }
            });
            //재고조회 버튼 클릭 이벤트
            $('.btn-invenCheck').on('click', function () {
                _this.invenCheck();
            });

            //재고수량 편집 클릭 이벤트
            $(document).on('click', '.editIcon', function () { //화면 렌더링후에 동적으로 생성된 태그의 이벤트는 읽을 수 없기 때문에
                var no = $(this).data("no");                   //document 자체에 클릭이벤트를 걸어 동적 생성 엘리먼트에 이벤트 적용 가능
                console.log(no);
                $(this).toggleClass("input");
                if($(this).hasClass("input")) {
                    $('#q-' + no).html("<input type='text' id='qu-"+no+"' name='quantity' style='width:30px;'>");
                }
                else {
                    var invenQuantity = $('#qu-'+no).val();

                    $.ajax({ // shoesNo + shoesSize json문자열로 컨트롤러에 넘기기
                                  type: 'PUT',
                                  url: '/api/invenQuantity/'+no,
                                  dataType: 'json',
                                  contentType: 'application/json; charset=utf-8',
                                  data: invenQuantity
                              }).done(function(quantity) {
                                $('#q-' + no).html('<span class="quantity">'+quantity+'</span>');
                              }).fail(function (error) {
                                  alert(JSON.stringify(error));
                              });
                    //$('#q-' + no).html('<span class="quantity">'+"변경"+'</span>');
                }
            });

    },
    invenCheck : function () { //재고조회 클릭 이벤트
        var user = $('.role').val();
        console.log(user);
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
              for(var i=0;i<list.length;i++){
              if(!user)
              storeList(list[i]);
              if(user)
              storeList2(list[i]);
              }
          }).fail(function (error) {
              alert(JSON.stringify(error));
          });
    },
    wishListAdd : function () { //위시리스트 클릭 이벤트
        console.log("위시리스트버튼");
        $(this).toggleClass("add");
        if($(this).hasClass("add")) {
            $(".wishIcon").attr("src", "/img/icon/heart2.png");
        }else{
            $(".wishIcon").attr("src", "/img/icon/heart1.png");
        }
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

function storeList2(list) {
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
    str += '<span id="q-'+list.invenNo+'" class="quantity">'+list.invenQuantity+'</span>';
    str += '<img data-no="'+list.invenNo+'" class="editIcon" src= "/img/icon/editIcon.png">';
    str += '</div>';
    str += '</div>';

    $(".shipping-body").append(str);
}
