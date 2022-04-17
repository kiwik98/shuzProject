var main = {
    init : function() {
            var _this = this;
            $('.shoes-sex').children('a').on('click', function() {
                var sex = $(this).text();
                console.log(sex);
            });

    }

};
main.init();