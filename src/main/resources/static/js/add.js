$(function () {

    var refreshWidth = function () {
        var _prev = $('#inputText').prev()
        var width = 0
        if (_prev.length > 0) {
            width = $('.container').width() - _prev.offset().left - _prev.outerWidth() - 10
        }
        if (_prev.length == 0 || width < 50) {
            width = '100%';
        }
        $('#inputText').css('width', width)
    }

    var appendFun = function (html, type) {

        $('#inputText').before('<span class="active">' + html + '<i data-type="' + type + '" data-value="' + html + '">x</i></span>')

        refreshWidth()

        $('.input-text').delegate('i', 'click', function () {
            var tagType = $(this).data('type')
            var tagHtml = $(this).data('value')
            if (tagType == 'tag') {
                $('.tag-list span').each(function (_, n) {
                    if (n.innerText == tagHtml) {
                        $(n).removeClass('active')
                        return false
                    }
                })
            }
            $(this).parent().remove()
            refreshWidth()
        })

    }
    $('#inputText').on('blur', function () {
        var html = this.value;
        if (html != '') {
            appendFun(html, 'input')
            this.value = ''
        }
    });
    $('#inputText').on('keypress', function (event) {
        if (event.keyCode != 13) {
            return;
        }
        var html = this.value;
        if (html != '') {
            appendFun(html, 'input')
            this.value = ''
        }
    });
    $('#inputText').on('keydown', function () {
        if (event.keyCode != 13) {
            return;
        }
        var html = this.value;
        if (html != '') {
            appendFun(html, 'input')
            this.value = ''
        }
    });
    $('.tag-list span').on('click', function () {
        if (!$(this).hasClass('active')) {
            var html = this.innerText;
            if (html != '') {
                $(this).addClass('active')
                appendFun(html, 'tag')
            }
        }

    });
    $("#query").on("click", function () {
        var appName = $("#appName").val();
        if(!appName){
            alert("请选择一个APP");
            return;
        }
        var productId = $("#productId").val();
        if(!productId){
            alert("请填写productId");
            return;
        }
        $.ajax({
            type:'POST',
            url:"product/find",
            data:{appName:appName,productId:productId},
            success:function(message){
                var obj = JSON.parse(message);
                for (var configItem in obj){
                    var html = configItem.config;
                    if(configItem.type){
                        html = html+",D";
                    }
                    appendFun(html, 'tag');
                }
            }
        });
    })

});