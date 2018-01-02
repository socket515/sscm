$(document).ready(
        function() {
            $('.menutd2').mousemove(function() {
                this.className = "menutdchange";
            });
            $('.menutd2').mouseout(function() {
                this.className = "menutd2";
            });
            $('.worktable2 tr:not(.th)').mousemove(function() {
                this.className = "worktrchange";
            });
            $('.worktable2 tr:not(.th)').mouseout(function() {
                this.className = "worktr";
            });
        });