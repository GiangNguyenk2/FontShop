<%-- 
    Document   : Profile
    Created on : May 21, 2023, 1:55:35 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>ShopAll</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="../stylesheet/profile.css">
        <link
            href="https://fonts.googleapis.com/css2?family=Alegreya&family=MuseoModerno:wght@200;300;400;500;600;800;900&family=Open+Sans:ital,wght@0,300;1,300&display=swap"
            rel="stylesheet">

        <style>
            .inputGroup {
                font-family: 'Segoe UI', sans-serif;
                margin: 1em 0 1em 0;
                max-width: 190px;
                position: relative;
            }

            .inputGroup input {
                font-size: 100%;
                padding: 5px;
                outline: none;
                border: 2px solid black;
                background-color: transparent;
                border-radius: 20px;
                width: 100%;
            }

            .inputGroup label {
                font-size: 100%;
                position: absolute;
                left: 0;
                padding: 5px;
                margin-left: 0.5em;
                pointer-events: none;
                transition: all 0.3s ease;
                color: rgb(100, 100, 100);
            }

            .inputGroup :is(input:focus, input:valid)~label {
                transform: translateY(-50%) scale(.9);
                margin: 0em;
                margin-left: 1.3em;
                padding: 2px;
                background-color: #e7e7e7;
                border : none;
            }

            .inputGroup :is(input :focus, input:valid ){
                border-color: black;

            }

            .wrapper {
                --font-color-dark: #323232;
                --font-color-light: #e7e7e7;
                --bg-color:#e7e7e7;
                --main-color: #323232;
                position: relative;
                width: 170px;
                height: 34px;
                background-color: var(--bg-color);
                border: 2px solid var(--main-color);
                border-radius: 34px;
                display: flex;
                flex-direction: row;
                box-shadow: 2px 2px var(--main-color);
                padding: 2.5px;

            }

            .option {
                width: 80.5px;
                height: 28px;
                position: relative;
                top: 2px;
                left: 2px;
            }

            .check {
                width: 100%;
                height: 100%;
                position: absolute;
                left: 0;
                top: 0;
                appearance: none;
                cursor: pointer;
            }

            .ok {
                width: 100%;
                height: 100%;
                background-color: var(--bg-color);
                border-radius: 50px;
                display: flex;
                justify-content: center;
                align-items: center;
            }

            .span {
                color: var(--font-color-dark);
            }

            .check:checked + .ok {
                background-color: var(--main-color);
            }

            .check:checked + .ok .span {
                color: var(--font-color-light);
            }

            button {
                position: relative;
                display: inline-block;
                cursor: pointer;
                outline: none;
                border: 0;
                vertical-align: middle;
                text-decoration: none;
                background: transparent;
                padding: 0;
                font-size: inherit;
                font-family: inherit;
            }

            button.learn-more {
                width: 12rem;
                height: auto;
            }

            button.learn-more .circle {
                transition: all 0.45s cubic-bezier(0.65, 0, 0.076, 1);
                position: relative;
                display: block;
                margin: 0;
                width: 3rem;
                height: 3rem;
                background: #282936;
                border-radius: 1.625rem;
            }

            button.learn-more .circle .icon {
                transition: all 0.45s cubic-bezier(0.65, 0, 0.076, 1);
                position: absolute;
                top: 0;
                bottom: 0;
                margin: auto;
                background:black;
            }

            button.learn-more .circle .icon.arrow {
                transition: all 0.45s cubic-bezier(0.65, 0, 0.076, 1);
                left: 0.625rem;
                width: 1.125rem;
                height: 0.125rem;
                background: none;
            }

            button.learn-more .circle .icon.arrow::before {
                position: absolute;
                content: "";
                top: -0.29rem;
                right: 0.0625rem;
                width: 0.625rem;
                height: 0.625rem;
                border-top: 0.125rem solid #fff;
                border-right: 0.125rem solid #fff;
                transform: rotate(45deg);
            }

            button.learn-more .button-text {
                transition: all 0.45s cubic-bezier(0.65, 0, 0.076, 1);
                position: absolute;
                top: 0;
                left: 0;
                right: 0;
                bottom: 0;
                padding: 0.75rem 0;
                margin: 0 0 0 1.85rem;
                color: #282936;
                font-weight: 700;
                line-height: 1.6;
                text-align: center;
                text-transform: uppercase;
            }

            button:hover .circle {
                width: 100%;
            }

            button:hover .circle .icon.arrow {
                background: #fff;
                transform: translate(1rem, 0);
            }

            button:hover .button-text {
                color: #fff;
            }
            .button-name {
                align-items: center;
                appearance: none;
                background-color: #323232;
                border-radius: 4px;
                border-width: 0;
                box-shadow: rgba(45, 35, 66, 0.2) 0 2px 4px,rgba(45, 35, 66, 0.15) 0 7px 13px -3px,#D6D6E7 0 -3px 0 inset;
                box-sizing: border-box;
                color: #f2f2f2;
                cursor: pointer;
                display: inline-flex;
                font-family: "JetBrains Mono",monospace;
                width: fit-content;
                height: 30px;
                justify-content: center;
                line-height: 1;
                list-style: none;
                overflow: hidden;
                padding-left: 5px;
                padding-right: 5px;
                margin: auto;
                position: relative;
                text-align: left;
                text-decoration: none;
                transition: box-shadow .15s,transform .15s;
                user-select: none;
                -webkit-user-select: none;
                touch-action: manipulation;
                white-space: nowrap;
                will-change: box-shadow,transform;
                font-size: 18px;
            }

            .button-name:focus {
                box-shadow: #D6D6E7 0 0 0 1.5px inset, rgba(45, 35, 66, 0.4) 0 2px 4px, rgba(45, 35, 66, 0.3) 0 7px 13px -3px, #D6D6E7 0 -3px 0 inset;
            }

            .button-name:hover {
                box-shadow: rgba(45, 35, 66, 0.3) 0 4px 8px, rgba(45, 35, 66, 0.2) 0 7px 13px -3px, #D6D6E7 0 -3px 0 inset;
                transform: translateY(-2px);
            }

            .button-name:active {
                box-shadow: #D6D6E7 0 3px 7px inset;
                transform: translateY(2px);
            }

           

            

            body {

                margin: 0;

                padding: 0;

                font-family: 'Roboto Condensed', sans-serif;

            }

            /* Overlay Styles */

            .overlay {

                background: rgba(0, 0, 0, 0.8);

                opacity${o.ID}: 0.8;

                filter: alpha(opacity${o.ID}=80);

                position: absolute;

                top: 0px;

                bottom: 0px;

                left: 0px;

                right: 0px;

                z-index: 100;

            }

            /* Popup */

            .popup {

                background: white;

                position: absolute;

                top: 0;

                left: 0;

                bottom: 0;

                right: 0;

                z-index: 101;

                width: 500px;

                /*Change your width here*/

                height: 200px;

                /*Change your height here*/

                margin: auto;

                /* Popup Inner */

            }

            @media (max-width: 768px) {

                .popup {

                    width: 90%;

                    margin: auto 5%;

                }

            }

            .popup .popup-inner {

                position: relative;

                padding: 1em;

            }

            .popup .popup-inner input.s3-btn-close {

                position: absolute;

                top: -0.5em;

                right: -0.5em;

                background: black;

                border: solid 2px white;

                color: white;

                cursor: pointer;

                border-radius: 15px;

                outline: none;

            }

            /*************
                    
            S3 Button
                    
            *************/

            input.s3-btn {

                background: #4E92DF;

                border: none;

                width: 30%;

                height: 50px;

                cursor: pointer;

                position: absolute;

                top: 0;

                color: white;

                right: 0;

                bottom: 0;

                left: 0;

                margin: auto;

                font-size: 18pt;



            }

            .s3-center {

                text-align: center;

            }
        </style>
    </head>


    <body>

        <jsp:include page="../components/Menu.jsp"/>


        <div style="justify-content: center; display: flex">
            <form action="userInfo?" method="get">
                <input type="hidden" value="${sessionScope.account.gmail}" name="accId">
                <input type="submit" value="History" style="border: none; background-color: #000; color: #f2f2f2; font-weight:  bolder; padding: 5px; border-radius: 5px; margin-top: 20px; margin-right: 10px">
            </form>

            <form action="changePassword" method="get">
                <input type="submit" value="Change Password"  style="border: none; background-color: #000; color: #f2f2f2; font-weight:  bolder; padding: 5px; border-radius: 5px; margin-top: 20px; margin-left: 10px">
            </form>
        </div>
        <h1 style="text-align: center; margin: 20px;">Update Profile</h1>
        <div class="profile" style="margin-bottom: 200px">
            <div class="boxleft">
                <p>${messprofile}</p>
                <h3 style="margin-bottom: 20px;">About</h3>
                <form action="updateProfile" method="post">
                    <div style="display: flex; align-items: center">

                        <div class="inputGroup" style="height: auto">
                            <input type="text" required="" autocomplete="off"  value="${sessionScope.account.name}" name = "name">
                            <label for="name">Name</label>
                        </div>

                        <!-- <p> Gender:</p> -->
                        <div  style="display: flex; justify-content: center; width: 35%"> 

                            <div class="wrapper" style="margin: auto;height: auto">
                                <div class="option">
                                    <input class="check" type="radio" id="nam" name="gender" value="true" ${sessionScope.account.gender?"checked":""}  required>
                                    <div class="ok">
                                        <span class="span">Male</span>
                                    </div>
                                </div>
                                <div class="option">
                                    <input class="check" type="radio" id="nu" name="gender" value="false" ${sessionScope.account.gender?"":"checked"} required>
                                    <div class="ok">
                                        <span class="span">Female</span>
                                    </div>  </div>
                            </div>
                        </div>
                    </div>

                    <button class="learn-more"  type="submit" style="margin-top: 60px">
                        <span class="circle" aria-hidden="true">
                            <span class="icon arrow"></span>
                        </span>
                        <span class="button-text">Update</span>
                    </button>
                </form>
            </div>
            <div class="boxright">
                <p>${mess}</p>
                <h3>Address List</h3>
                <table>
                    <tr>
                        <th>Phone</th>
                        <th>Address</th>
                    </tr>
                    <c:forEach items="${listadd}" var="o">
                        <tr>

                        <form action="updateAddress" method="post">
                            <td>
                                <div>
                                    <select id="city${o.ID}" value="" name="city${o.ID}">
                                        <option value="${o.city}" selected>${o.city}</option>           
                                    </select>

                                    <select id="district${o.ID}" value="" name="district${o.ID}">
                                        <option value="${o.district}" selected>${o.district}</option>
                                    </select>

                                    <select id="ward${o.ID}" value="" name="ward${o.ID}">
                                        <option value="${o.ward}" selected>${o.ward}</option>
                                    </select>
                                </div>    
                                <input type="text" required="" value="${o.address}" name = "diachi">

                                <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
                                <script>
                                    var citis${o.ID} = document.getElementById("city${o.ID}");
                                    var districts${o.ID} = document.getElementById("district${o.ID}");
                                    var wards${o.ID} = document.getElementById("ward${o.ID}");
                                    var Parameter = {
                                        url: "https://raw.githubusercontent.com/kenzouno1/DiaGioiHanhChinhVN/master/data.json",
                                        method: "GET",
                                        responseType: "application/json",
                                    };
                                    var promise = axios(Parameter);
                                    promise.then(function (result) {
                                        renderCity${o.ID}(result.data);
                                    });

                                    function renderCity${o.ID}(data) {
                                        for (const x of data) {
                                            var opt = document.createElement('option');
                                            opt.value = x.Name;
                                            opt.text = x.Name;
                                            opt.setAttribute('data-id', x.Id);
                                            citis${o.ID}.options.add(opt);
                                        }
                                        citis${o.ID}.onchange = function () {
                                            district${o.ID}.length = 1;
                                            ward${o.ID}.length = 1;
                                            if (this.options[this.selectedIndex].dataset.id != "") {
                                                const result = data.filter(n => n.Id === this.options[this.selectedIndex].dataset.id);

                                                for (const k of result[0].Districts) {
                                                    var opt = document.createElement('option');
                                                    opt.value = k.Name;
                                                    opt.text = k.Name;
                                                    opt.setAttribute('data-id', k.Id);
                                                    district${o.ID}.options.add(opt);
                                                }
                                            }
                                        };
                                        district${o.ID}.onchange = function () {
                                            ward${o.ID}.length = 1;
                                            const dataCity = data.filter((n) => n.Id === citis${o.ID}.options[citis${o.ID}.selectedIndex].dataset.id);
                                            if (this.options[this.selectedIndex].dataset.id != "") {
                                                const dataWards = dataCity[0].Districts.filter(n => n.Id === this.options[this.selectedIndex].dataset.id)[0].Wards;

                                                for (const w of dataWards) {
                                                    var opt = document.createElement('option');
                                                    opt.value = w.Name;
                                                    opt.text = w.Name;
                                                    opt.setAttribute('data-id', w.Id);
                                                    wards${o.ID}.options.add(opt);
                                                }
                                            }
                                        };
                                    }
                                </script>
                                </div>
                                </div>  
                            </td>
                            <td><div class="inputGroup" style="height: auto">
                                    <input style="color: white; border-bottom-color: #8b8986; " type="text" required="" autocomplete="off"  value="${o.phone}" name = "phone">
                                </div></td> 
                            <td><div class="inputGroup" style="height: auto">
                                    <input style="color: white; border-bottom-color: #8b8986" type="text" required="" autocomplete="off"  value="${o.city},${o.district},${o.ward},${o.address}" name = "address">
                                </div></td> 
                            <td><input type="hidden" value="${o.ID}" name="ID"></td>

                            <td> <button role="button" class="button-name" type="submit" >Update</button></td>

                        </form>
                        <form action="deleteAddress" method="post">
                            <td> <button role="button" class="button-name" type="submit">Delete</button></td>
                            <input type="hidden" value="${o.ID}" name="ID">
                        </form>

                        </tr>
                    </c:forEach>
                </table>
            </div>

        </div>


        <div class="pagination" style="margin: auto; justify-content: center; ">

        </div>

        <jsp:include page="../components/Footer.jsp"/>
    </body>

</html>
