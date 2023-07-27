<%-- 
    Document   : Privacy
    Created on : May 23, 2023, 4:08:46 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Privacy&Policy</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link href="../stylesheet/privacy.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
        <link
            href="https://fonts.googleapis.com/css2?family=Alegreya&family=MuseoModerno:wght@200;300;400;500;600;800;900&family=Open+Sans:ital,wght@0,300;1,300&display=swap"
            rel="stylesheet">
        <style>
            .wel {
                background-color: #000000;
                text-align: center;
                margin-bottom: 0;
                transition: all ease .55s;
            }

            .wel h6 {
                color: #fcfcfc;
                font-size: 20px;
                margin-bottom: 0;
                padding: 3px;
            }




            .topnav {
                position: relative;
                background-color: #ffffff;
                overflow: hidden;
                width: 100%;
                transition: all ease .55s;

            }

            /* Style the links inside the navigation bar */
            .topnav a {
                float: left;
                color: #000000;
                text-align: center;
                padding: 10px 14px;
                text-decoration: none;
                font-size: 15px;
                font-weight: 500;

            }

            /* Change the color of links on hover */
            .topnav a:hover {

                color: #000000;
                font-weight: 700;
            }



            /* Centered section inside the top navigation */
            .topnav-centered a {
                float: none;
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
            }

            /* Right-aligned section inside the top navigation */
            .topnav-right {
                justify-content: space-evenly;
                float: right;
                right: 0;
                display: flex;
                width: 35%;
                margin-left: 20px;

            }

            .topnav-right a {
                padding: 0;



            }

            .topnav-right input {
                width: 40%;
                border: none;
                top: 0;
                height: fit-content;
                font-size: 17px;
                padding: 10px 14px;
            }

            .topnav-right button {
                width: 20%;
                padding: 0;
                background-color: rgb(255, 255, 255);
                border-radius: 20px;
                height: fit-content;
                border: 0;
                padding: 10px 14px;

            }

            .topnav-right a {
                float: left;
                color: #000000;
                text-align: center;
                margin-top: 10px;
                text-decoration: none;
                font-size: 15px;
                font-weight: 500;
            }

            .example {
                width: 50%;
                display: flex;
                justify-content: end;


            }

            /* Responsive navigation menu - display links on top of each other instead of next to each other (for mobile devices) */
            @media screen and (max-width: 600px) {

                .topnav a,
                .topnav-right {
                    float: none;
                    display: block;
                }

                .topnav-centered a {
                    position: relative;
                    top: 0;
                    left: 0;
                    transform: none;
                }
            }
            
             .footer {
    position: static;
    left: 0;
    bottom: 0;
    width: 100%;
    background-color: rgb(0, 0, 0);
    color: white;
    text-align: center;
  }
  
  .footer {
    width: 100%;
    background-color: rgb(0, 0, 0);
    color: white;
    text-align: center;
    margin-top: 30px;
  }
  .footer {
    width: 100%;
    background-color: rgb(0, 0, 0);
    color: white;
    text-align: center;
  }
  .footer p{
    margin: 0;
  
  }

        </style>

    </head>
    <body style="">
        <jsp:include page="../components/Menu.jsp"></jsp:include>
        <div style="width: 80%; margin: auto">
            <div class="privacy">
                <h1 style="text-align: center">Privacy&Policy</h1>
                <p>FrontShop cam kết xây dựng và công bố chính sách bảo mật thông tin khi thu thập và sử dụng thông tin cá nhân của người tiêu dùng với đầy đủ các nội dung sau: </p>

                <h3>A. Nguyên Tắc Chung:</h3>
                <p>1. Chính sách bảo mật thông tin này (“Chính Sách Bảo Mật FrontShop”) mô tả cách thức cửa hàng FrontShop (“FrontShop” hoặc “chúng tôi”) thu thập, tiếp nhận, tổng hợp, lưu giữ, sử dụng, xử lý, tiết lộ, chia sẻ và bảo đảm an toàn thông tin của các tổ chức, cá nhân (“Người Dùng” hoặc “Quý Khách”),
                    bao gồm khách hàng, đại lý, đối tác:
                    (i) truy cập, sử dụng các kênh tương tác khách hàng thuộc sở hữu của cửa hàng, bao gồm nhưng không giới hạn: ứng dụng di động FrontShop, website www.FrontShop.com, và hội nhóm trên các trang mạng xã hội (như facebook, Instagram, Tiktok …) 
                    thuộc sở hữu của cửa hàng(“Kênh FrontShop”); 
                    (ii) là khách hàng thân thiết trong Chương trình Chăm Sóc Khách Hàng Thân Thiết của FrontShop (“Chương Trình”); và/hoặc (iii) mua bán các loại hàng hóa do FrontShop cung cấp (mục (i), (ii) và (iii) gọi chung là “Dịch Vụ”).
                    Vui lòng đọc kỹ Chính Sách Bảo Mật FrontShop này, các điều khoản điều kiện tương ứng và các quy định khác (nếu có).
                </p>
                <p>2. Chính Sách Bảo Mật FrontShop bao gồm các nội dung sau:</p>
                <div class="Text1">
                    <p>a. Sự chấp thuận</p>
                    <p>b. Mục đích thu thập</p>
                    <p>c. Phạm vi thu thập</p>
                    <p>d. Thời gian lưu trữ</p>
                    <p>e. Không chia sẻ thông tin cá nhân khách hàng</p>
                    <p>f. An toàn dữ liệu</p>
                    <p>g. Quyền của Khách hàng đối với thông tin cá nhân</p>
                    <p>h. Trách nhiệm của khách hàng để đảm bảo bảo mật thông tin</p>
                    <p>i. Cách thức liên hệ với FrontShop</p>
                    <p>j. Đơn vị thu thập và quản lý thông tin</p>
                </div>

                <h3>B. Nội dung chi tiết</h3>

                <h5>1. Sự Chấp Thuận</h5>
                Bằng việc trao cho chúng tôi thông tin cá nhân của Quý khách khi sử dụng các Dịch vụ, Quý khách đồng ý các thông tin cá nhân của Quý khách sẽ được thu thập, sử dụng như được nêu trong Chính Sách này. Nếu Quý khách không đồng ý với Chính Sách này, Quý khách có thể dừng cung cấp cho Chúng tôi bất kỳ thông tin cá nhân nào và/hoặc sử dụng các quyền như được nêu tại mục 7 dưới đây.
                FrontShop bảo lưu quyền sửa đổi, bổ sung nhằm hoàn thiện đối với Chính sách này vào bất kỳ thời điểm nào. Chúng tôi khuyến khích Quý Khách thường xuyên xem lại Chính sách bảo mật thông tin FrontShop để được cập nhật mới nhất đảm bảo Quý Khách đã biết và thực hiện quyền quản lý thông tin của mình.
                Chúng tôi cam kết công bố công khai chính sách bảo mật thông tin tại vị trí dễ thấy trên website nếu việc thu thập thông tin được thực hiện thông qua các kênh của FrontShop.

                <h5>2. Mục đích thu thập thông tin cá nhân khách hàng</h5>
                FrontShop thu thập thông tin người dùng nhằm phục vụ cho các mục đích:

                Đơn hàng: để xử lý các vấn đề liên quan đến đơn đặt hàng của Quý khách;
                Duy trì tài khoản: Để tạo và duy trì tài khoản của Qúy khách, bao gồm các chương trình khách hàng thân thiết, sử dụng điểm C-Point, các chương trình khuyến mại,… đi kèm với tài khoản của Quý khách;
                Cung cấp các dịch vụ/ tiện ích cho KH dựa trên nhu cầu và các thói quen của KH mua sắm tại FrontShop;
                Gửi thông báo Giới thiệu các sản phẩm, chương trình, dịch vụ mới của FrontShop
                Dịch vụ Người Dùng, Dịch vụ Chăm sóc khách hàng: bao gồm các phản hồi cho các yêu cầu, khiếu nại và phản hồi của Quý Khách;
                An ninh: cho mục đích phát hiện, ngăn chặn các hoạt động giả mạo, chiếm dụng tài khoản của KHTT nhằm mục địch trục lợi, gian lận;
                Theo yêu cầu của pháp luật: tùy quy định của pháp luật vào từng thời điểm, chúng tôi có thể thu thập, lưu trữ và cung cấp theo yêu cầu của cơ quan nhà nước có thẩm quyền.
                <h5>3. Phạm vi thu thập</h5>
                Các loại thông tin được chúng tôi thu thập và hình thức thu thập thông tin như sau:

                Thông tin quý khách cung cấp cho chúng tôi: Đó là các thông tin cá nhân Quý khách cung cấp cho chúng tôi được thực hiện chủ yếu trên các kênh FrontShop bao gồm bất kỳ thông tin, dữ liệu nào có thể được sử dụng để nhận dạng Quý Khách hoặc dựa vào đó mà Quý khách được xác định, chẳng hạn như tên, số điện thoại, chi tiết thẻ thanh toán và ngân hàng, địa chỉ email, thông tin CMND/thẻ căn cước công dân (nếu có), ngày sinh, thông tin đăng nhập tài khoản như tên đăng nhập, mật khẩu đăng nhập, ID/địa chỉ đăng nhập, câu hỏi/ trả lời bảo mật.
                Thu thập và sử dụng Cookies
                FrontShop và các bên thứ ba mà FrontShop hợp tác (nếu có) có thể sử dụng các phương thức tự động (gọi chung là “Cookies”) có liên quan đến việc sử dụng Kênh FrontShop để nhận diện trình duyệt hoặc thiết bị của quý khách, tìm hiểu thêm về sở thích của Quý khách, cung cấp cho quý khách các tính năng và dịch vụ thiết yếu và cho các mục đích bổ sung khác. Cookies có thể chứa đựng các công cụ định danh độc nhất và được lưu trữ tại máy tính hoặc thiết bị di động của Quý khách, trong email mà FrontShop gửi, trên các Kênh FrontShop, và tại một số địa điểm khác. Cookies có thể truyền tải Thông Tin cá nhân và việc sử dụng Dịch Vụ.

                FrontShop có thể chia sẻ Thông Tin cá nhân thu thập qua Cookies không mang tính nhận dạng cá nhân với các bên thứ ba, chẳng hạn như dữ liệu vị trí, số nhận dạng quảng cáo hoặc số nhận dạng tài khoản chung (như địa chỉ email), để tạo điều kiện hiển thị quảng cáo.
                Quý khách có thể quản lý Cookies trình duyệt bằng việc cài đặt trình duyệt của mình, chặn hoặc ngừng hoạt động Cookies, bằng cách xóa lịch sử trình duyệt và xóa bộ nhớ cache khỏi trình duyệt internet của mình. Quý khách cũng có thể giới hạn việc chia sẻ của chúng tôi về một số Thông Tin cá nhân này thông qua cài đặt thiết bị di động của mình. Nếu Quý khách tắt tất cả Cookies, cả chúng tôi và bên thứ ba sẽ không thể chuyển Cookies sang hoặc từ trình duyệt của quý khách. Tuy nhiên, nếu quý khách làm điều này, Quý khách có thể phải tự tay điều chỉnh một số tùy chọn mỗi khi quý khách truy cập lại vào Dịch Vụ và một số tính năng, kênh và dịch vụ có thể không hoạt động
                Thông tin từ các nguồn khác: Chúng tôi có thể thu thập thông tin cá nhân từ các nguồn hợp pháp khác như chương trình khuyến mại, khảo sát,…
                <h5>4. Thời gian lưu trữ</h5>
                Thông tin cá nhân của khách hàng sẽ được lưu trữ và bảo mật trên hệ thống của FrontShop cho đến khi khách hàng tự đăng nhập và thực hiện hủy bỏ hoặc có yêu cầu FrontShop hủy bỏ trên hệ thống. Trong mọi trường hợp, thông tin cá nhân của khách hàng sẽ được bảo mật trên máy chủ của FrontShop.com

                <h5>5. Không chia sẻ thông tin cá nhân khách hàng</h5>
                Chúng tôi sẽ không cung cấp thông tin cá nhân của Quý khách cho bất kỳ bên thứ ba nào, trừ một số hoạt động cần thiết sau:

                Các bên cung cấp dịch vụ (ví dụ: đối tác trong các lĩnh vực như dịch vụ thanh toán, dịch vụ vận chuyển và giao nhận , tiếp thị, phân tích dữ liệu hoặc nghiên cứu khảo sát khách hàng, truyền thông xã hội, dịch vụ khách hàng, dịch vụ cài đặt, công nghệ thông tin và, dịch vụ lưu trữ web)
                Yêu cầu pháp lý: FrontShop có thể tiết lộ các thông tin cá nhân nếu điều đó do luật pháp yêu cầu và việc tiết lộ như vậy là cần thiết để tuân thủ quy trình pháp lý
                Chuyển giao kinh doanh (nếu có): trong trường hợp sáp nhập, hợp nhất toàn bộ hoặc một phần với công ty khác.
                <h5>6. An toàn dữ liệu</h5>
                FrontShop luôn nỗ lực để giữ an toàn thông tin cá nhân của KH, Chúng tôi đã và đang thực hiện nhiều biện pháp an toàn, bao gồm:

                Bảo đảm an toàn trong môi trường vận hành: FrontShop lưu trữ thông tin cá nhân khách hàng trong môi trường vận hành an toàn và chỉ có nhân viên, đại diện có thể truy cập trên cơ sở cần phải biết. FrontShop tuân theo các tiêu chuẩn ngành, pháp luật trong việc bảo mật thông tin cá nhân KH.
                Trong trường hợp máy chủ lưu trữ thông tin bị hacker tấn công dẫn đến mất mát dữ liệu Thông tin KH, FrontShop sẽ có trách nhiệm thông báo vụ việc cho cơ quan chức năng điều tra xử lý kịp thời và thông báo cho KH được biết.
                FrontShop cam kết bảo mật mọi thông tin giao dịch trực tuyến của KH. Mọi Thông Tin KH, cũng như các thông tin trao đổi giữa KH và FrontShop đều được lưu giữ và bảo mật bởi hệ thống của FrontShop.
                FrontShop có các biện pháp thích hợp về kỹ thuật và an ninh để ngăn chặn việc truy cập, sử dụng trái phép Thông Tin KH. Tuy nhiên, Quý khách nên hiểu rằng không có phương thức truyền tải nào qua Internet hoặc phương thức lưu trữ điện tử là an toàn tuyệt đối. Mặc dù việc bảo mật không thể đảm bảo tuyệt đối, nhưng chúng tôi nỗ lực để bảo vệ an toàn thông tin của Quý khách và liên tục rà soát và nâng cấp các biện pháp bảo mật thông tin của chúng tôi.
                <h5>7. Quyền của Khách hàng đối với thông tin cá nhân</h5>
                KH có quyền cung cấp thông tin cá nhân cho chúng tôi và có quyền thay đổi quyết định đó bất kỳ lúc nào.
                KH có quyền tự kiểm tra, cập nhật, điều chỉnh hoặc hủy bỏ Thông tin cá nhân của mình bằng cách đăng nhập vào tài khoản trên Website/ Ứng dụng FrontShop để chỉnh sửa thông tin cá nhân hoặc yêu cầu FrontShop thực hiện việc này.
                <h5>8. Trách nhiệm của Khách hàng để đảm bảo bảo mật thông tin</h5>
                KH có trách nhiệm bảo vệ thông tin tài khoản của mình và không cung cấp bất kỳ thông tin nào liên quan đến tài khoản và mật khẩu truy cập tài khoản FrontShop cho bên nào khác. Trường hợp KH tiết lộ thông tin dẫn đến thiệt hại, FrontShop sẽ không chịu bất kỳ trách nhiệm nào đối với tất cả những vấn đề phát sinh.
                FrontShop không chịu trách nhiệm về những vấn đề phát sinh khi KH truy cập vào website, ứng dụng di động, các kênh truyền thông khác không phải là website, ứng dụng di động, kênh truyền thông chính thức của Công ty.
                KH tuyệt đối không được có bất kỳ hành vi sử dụng công cụ, chương trình để can thiệp trái phép vào hệ thống của FrontShop, cũng như bất kỳ hành vi nào khác nhằm phát tán, cổ vũ cho các hoạt động với mục đích can thiệp, phá hoại hay xâm nhập vào dữ liệu của website hoặc ứng dụng FrontShop, cũng như các hành vi mà pháp luật Việt Nam nghiêm cấm. Trong trường hợp FrontShop phát hiện KH có hành vi cố tình giả mạo, gian lận, phát tán các thông tin trái phép,…FrontShop có toàn quyền chuyển Thông tin KH cho các cơ quan có thẩm quyền để xử lý theo quy định pháp luật.
                <h5>9. Cách thức liên hệ với FrontShop</h5>

                <p>Bất kỳ khi nào KH cần hỗ trợ, hãy liên hệ với của FrontShop</p>
                <p>Hỗ trợ mua Online: 1800.6061 / Email: dodvhe161048@fpt.edu.vn</p>
                <p>Liên hệ Chăm sóc KH: 1800.6061 / Email: dodvhe161048@fpt.edu.vn</p>
                <p>Văn phòng miền Bắc: +8424-7303.0222/ Email: dodvhe161048@fpt.edu.vn</p>
                <p>KH có quyền gửi khiếu nại về việc bị lộ thông tin cá nhân cho bên thứ ba đến Ban quản trị của Ứng dụng FrontShop hoặc đến địa chỉ công ty hoặc phản ánh qua mail: dodvhe161048@fpt.edu.vn. Khi tiếp nhận những phản hồi này, Công ty sẽ xác nhận lại thông tin, có trách nhiệm trả lời lý do và hướng dẫn KH khôi phục và bảo mật lại thông tin.</p>
                <p>FrontShop có trách nhiệm thực hiện các biện pháp kỹ thuật, nghiệp vụ để xác minh các nội dung được phản ánh trong vòng 15 ngày.</p>
                <p>Đơn vị thu thập và quản lý thông tin: Quản lí cửa hàng FrontShop <strong>Đinh Văn Độ</strong> </p>


                <p>Địa chỉ liên hệ: Trường đại học FPT, KM29, Đại lộ Thăng Long, Huyện Thạch Thất, Hà Nội</p>
            </div>

        </div>
            
        <jsp:include page="../components/Footer.jsp"></jsp:include>
    </body>
</html>
