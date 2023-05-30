<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

    <script src="js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="css/style.css" rel="stylesheet">

</head>
<body class="bg-funky">
<div class="container">
    <h3 class="heading text-center">Chat Bubble</h3>
    <div class="messaging" id="messaging">


    </div>
    <form method="post" action="MessageServlet" id="messageForm" class="message-form">
        <div class="container1">
            <input type="text" class="input1" name="message" placeholder="Type your message...">
            <button class="button1" class="seb">Submit</button>
        </div>
    </form>
</div>
<script>
    function refreshChatRoom() {
        $.ajax({
            url: 'chatting1.jsp',
            type: 'GET',
            success: function (data) {
                $('#messaging').html(data);
                $('#messaging').scrollTop($('#messaging')[0].scrollHeight);
            },
            error: function () {
                console.log('Error occurred while refreshing the chat room.');
            }
        });
    }

    refreshChatRoom();

    setInterval(refreshChatRoom, 3000);

    $('#messageForm').submit(function (e) {
        e.preventDefault();

        var formData = $(this).serialize();

        $.ajax({
            url: 'MessageServlet',
            type: 'POST',
            data: formData,
            success: function () {
                $('#messageForm')[0].reset();
                refreshChatRoom();
            },
            error: function () {
                console.log('Error occurred while sending the message.');
            }
        });
    });
</script>
</body>
</html>