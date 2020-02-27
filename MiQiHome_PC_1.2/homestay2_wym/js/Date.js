 //网页加载时初始化年月
        window.onload=function() {
            //初始的每月天数
            m = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
            //先给年下拉框赋内容
            for (var i =1970; i <2020; i++)
                document.form.year.options.add(new Option(i , i));
            //赋月份的下拉框
            for (var i = 1; i < 13; i++)
                document.form.month.options.add(new Option( i, i));
        }
 
        /**
         * 年份发生变化时进行联动
         * @param year
         */
        function yearChange(year)
        {
            //获得下拉列表中月份
            var month = document.form.month.options[document.form.month.selectedIndex].value;
            if (month == "0") {
                var opt = document.form.day;
                dayOptionsClear(opt);
                return;
            }
            if (month == 2 && IsPrimYear(str)) {
                m[month - 1]=29;
            }
            writeDay(m[str - 1]);
        }
 
        /**
         *根据月份的更改对天数列表联动
         */
        function monthChange(month)
        {
            //获得年份，selectedIndex当前被选择的下标
            var Y= document.form.year.options[document.form.year.selectedIndex].value;
            if (Y== "0") {
                var opt = document.form.day;
                dayOptionsClear(opt);
            }
            if (month == 2 && IsPrimYear(Y)){
                m[month - 1]=29;
            }
            writeDay(m[month - 1]);
        }
 
        /**
         * 根据参数（当月的天数）添加天数的下拉列表
         * @param day_number
         */
        function writeDay(day_number) {
            var opt = document.form.day;
            dayOptionsClear(opt);
            for (var i = 1; i < (day_number + 1); i++)
                opt.options.add(new Option(i, i));
        }
 
        /**
         * 判断是否为闰年
         * @param year
         * @returns {boolean}
         * @constructor
         */
        function IsPrimYear(year)
        {
            return (0 == year % 4 && (year % 100 != 0 || year % 400 == 0));
        }
 
        //清空天数的下拉列表
        function dayOptionsClear(opt) {
            opt.options.length = 1;
        }