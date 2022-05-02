var main = {
    init : function() {
            var _this = this;

            $('.btn-invenCheck').on('click', function () {
                _this.invenCheck();
            });

    },
    invenCheck : function () {
        var no = $('.shoesNo').val();
        var size = $('input[name=sizeRadio]:checked').val();
        var data = {
            shoesNo: no,
            shoesSize: size
        };
        console.log(data);

        $.ajax({
              type: 'POST',
              url: '/api/invenSearch',
              dataType: 'json',
              contentType: 'application/json; charset=utf-8',
              data: JSON.stringify(data)
          }).done(function(data) {
              console.log(data);
          }).fail(function (error) {
              alert(JSON.stringify(error));
          });


    }

};
main.init();