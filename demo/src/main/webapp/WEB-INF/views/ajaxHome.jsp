<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <title>Home</title>
</head>

<script src="https://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        $("#getBtn").on("click", function () {
            var boardNo = $("#boardNo")
            var boardNoVal = boardNo.val()
            console.log(boardNoVal)

            $.get("/boards/" + boardNoVal, function (data) {
                console.log(data)

                alert(JSON.stringify(data))
            })
        })

        $("#getJsonBtn").on("click", function () {
            var boardNo = $("#boardNo")
            var boardNoVal = boardNo.val()

            console.log(boardNoVal)

            $.ajax({
                type: "get",
                url: "/boards/" + boardNoVal,
                headers: {
                    "Accept": "application/json"
                },
                success: function (result) {
                    console.log("result: " + result)

                    alert(JSON.stringify(result))
                }
            })
        })

        $("#getXmlBtn").on("click", function () {
            var boardNo = $("#boardNo")
            var boardNoVal = boardNo.val()

            console.log(boardNoVal)

            $.ajax({
                type: "get",
                url: "/boards/" + boardNoVal,
                headers: {
                    "Accept": "application/xml"
                },
                success: function (result) {
                    console.log("result: " + result)

                    alert(xmlToString(result))
                }
            })
        })
    })

    function xmlToString (xmlData) {
        var xmlString

        if (window.ActiveXObject) {
            xmlString = xmlData.xml;
        } else {
            xmlString = (new XMLSerializer()).serializeToString(xmlData)
        }

        return xmlString
    }
</script>

<body>
    <h1>Ajax Home</h1>

    <form>
        boardNo: <input type="text" name="boardNo" value="" id="boardNo"><br>
        title: <input type="text" name="title" value="" id="title"><br>
        content: <input type="text" name="content" value="" id="content"><br>
        writer: <input type="text" name="writer" value="" id="writer"><br>
    </form>

    <div>
        <button id="getBtn">Read</button>
        <button id="getJsonBtn">Read Json</button>
        <button id="getXmlBtn">Read Xml</button>
    </div>
</body>
</html>