$(function () {
    $.ajax({
        type:"get",//type可以为post也可以为get
        url:"JsonServlet",
        data:{},//这行不能省略，如果没有数据向后台提交也要写成data:{}的形式
        dataType:"json",//这里要注意如果后台返回的数据不是json格式，那么就会进入到error:function(data){}中
        success:function(data){

            //console.log(data);
            var arr = [],brr = [],crr = [];
            var len = data["length"];
            arr[0] = data["65"];
            arr[1] = data["66"];
            arr[2] = data["67"];
            arr[3] = data["68"];
            arr[4] = data["69"];
            arr[5] = data["70"];
            arr[6] = data["71"];
            arr[7] = data["72"];

            brr[0] = data["UnderWeight"];
            brr[1] = data["Thin"];
            brr[2] = data["Healthy"];
            brr[3] = data["OverWeight"];
            brr[4] = data["Obese"];
            //console.log((100*brr[2]/len).toFixed(2));
            crr[0] = (100*brr[0]/len).toFixed(2);
            crr[1] = (100*brr[1]/len).toFixed(2);
            crr[2] = (100*brr[2]/len).toFixed(2);
            crr[3] = (100*brr[3]/len).toFixed(2);
            crr[4] = (100*brr[4]/len).toFixed(2);


            //console.log(arr);
            var lineData = {
            labels: ["65", "66", "67", "68", "69", "70", "71", "72"],
            datasets: [
                {
                    label: "Example dataset",
                    fillColor: "#03A9F3",
                    strokeColor: "#FFAA00",
                    pointColor: "#00ACAC",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "#36a2eb",
                    data: arr,
                }
            ]
        };

            var lineOptions = {
                scaleShowGridLines: true,
                scaleGridLineColor: "rgba(0,0,0,.05)",
                scaleGridLineWidth: 1,
                bezierCurve: true,
                bezierCurveTension: 0.4,
                pointDot: true,
                pointDotRadius: 4,
                pointDotStrokeWidth: 1,
                pointHitDetectionRadius: 20,
                datasetStroke: true,
                datasetStrokeWidth: 2,
                datasetFill: true,
                responsive: true,
            };


            var ctx = document.getElementById("lineChart").getContext("2d");
            var myNewChart = new Chart(ctx).Line(lineData, lineOptions);

            var barData = {
                labels: ["UnderWeight", "Thin", "Healthy", "OverWeight", "Obese"],
                datasets: [
                    {
                        label: "Digital Goods",
                        fillColor: "#3374dd",
                        strokeColor: "#FB6D9D",
                        pointColor: "#3b8bba",
                        pointStrokeColor: "#ff6384",
                        pointHighlightFill: "#fff",
                        pointHighlightStroke: "rgba(60,141,188,1)",
                        data: crr,
                    }
                ]
            };

            var barChartOptions = {
                //Boolean - If we should show the scale at all
                showScale: true,
                //Boolean - Whether grid lines are shown across the chart
                scaleShowGridLines: false,
                //String - Colour of the grid lines
                scaleGridLineColor: "rgba(0,0,0,.05)",
                //Number - Width of the grid lines
                scaleGridLineWidth: 1,
                //Boolean - Whether to show horizontal lines (except X axis)
                scaleShowHorizontalLines: true,
                //Boolean - Whether to show vertical lines (except Y axis)
                scaleShowVerticalLines: true,
                //Boolean - Whether the line is curved between points
                bezierCurve: true,
                //Number - Tension of the bezier curve between points
                bezierCurveTension: 0.3,
                //Boolean - Whether to show a dot for each point
                pointDot: true,
                //Number - Radius of each point dot in pixels
                pointDotRadius: 4,
                //Number - Pixel width of point dot stroke
                pointDotStrokeWidth: 1,
                //Number - amount extra to add to the radius to cater for hit detection outside the drawn point
                pointHitDetectionRadius: 20,
                //Boolean - Whether to show a stroke for datasets
                datasetStroke: true,
                //Number - Pixel width of dataset stroke
                datasetStrokeWidth: 2,
                //Boolean - Whether to fill the dataset with a color
                datasetFill: true,
                //String - A legend template
                legendTemplate: "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<datasets.length; i++){%><li><span style=\"background-color:<%=datasets[i].lineColor%>\"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>",
                //Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
                maintainAspectRatio: true,
                //Boolean - whether to make the chart responsive to window resizing
                responsive: true
            }


            var ctx = document.getElementById("barChart").getContext("2d");
            var barChart = new Chart(ctx);

            var barChartData = barData;
            barChartData.datasets[0].fillColor = "#3374dd";
            barChartData.datasets[0].strokeColor = "#3374dd";
            barChartData.datasets[0].pointColor = "#ff6384";
            barChartOptions.datasetFill = false;
            barChart.Bar(barChartData, barChartOptions);

            var polarData = [
                {
                    value: brr[0],
                    color: "#ff6384",
                    highlight: "#F0A015",
                    label: "UnderWeight"
                },
                {
                    value: brr[1],
                    color: "#6059ee",
                    highlight: "#36A2EB",
                    label: "Thin"
                },
                {
                    value: brr[2],
                    color: "#03A9F3",
                    highlight: "#43b8b8",
                    label: "Healthy"
                },
                {
                    value: brr[3],
                    color: "#03A9F3",
                    highlight: "#43b8b8",
                    label: "OverWeight"
                },
                {
                    value: brr[4],
                    color: "#03A9F3",
                    highlight: "#43b8b8",
                    label: "Obese"
                }
            ];

            var polarOptions = {
                scaleShowLabelBackdrop: true,
                scaleBackdropColor: "rgba(255,255,255,0.75)",
                scaleBeginAtZero: true,
                scaleBackdropPaddingY: 1,
                scaleBackdropPaddingX: 1,
                scaleShowLine: true,
                segmentShowStroke: true,
                segmentStrokeColor: "#fff",
                segmentStrokeWidth: 2,
                animationSteps: 100,
                animationEasing: "easeOutBounce",
                animateRotate: true,
                animateScale: false,
                responsive: true,
            };

            var ctx = document.getElementById("polarChart").getContext("2d");
            var myNewChart = new Chart(ctx).PolarArea(polarData, polarOptions);

            var pieChartData = [
                {
                    value: 4714,
                    color: "#F0A015",
                    highlight: "#eebd45",
                    label: "UnderWeight"
                },
                {
                    value: 2533,
                    color: "#5CB85C",
                    highlight: "#ef5374",
                    label: "Thin"
                },
                {
                    value: 17087,
                    color: "#03A9F3",
                    highlight: "#4c44e5",
                    label: "Healthy"
                },
                {
                    value: 6,
                    color: "#36a2eb",
                    highlight: "#23DBDE",
                    label: "OverHeight"
                },
                {
                    value: 0,
                    color: "#F96262",
                    highlight: "#43b8b8",
                    label: "Obese"
                },
            ];

            var pieChartOptions = {
                segmentShowStroke: true,
                segmentStrokeColor: "#fff",
                segmentStrokeWidth: 2,
                percentageInnerCutout: 45, // This is 0 for Pie charts
                animationSteps: 100,
                animationEasing: "easeOutBounce",
                animateRotate: true,
                animateScale: false,
                responsive: true,
            };


            var ctx = document.getElementById("pieChart").getContext("2d");
            var pieChart = new Chart(ctx).Doughnut(pieChartData, pieChartOptions);
        },
        error:function(){
            alert("数据获取出错！");
        }
    });


});