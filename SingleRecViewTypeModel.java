package com.example.myapplication;

public class SingleRecViewTypeModel {

        private int drawable;
        private String firstLine;
        private String secondLine;

        public SingleRecViewTypeModel() {
        }

        public SingleRecViewTypeModel(int drawable, String firstLine, String secondLine) {
            this.drawable = drawable;
            this.firstLine = firstLine;
            this.secondLine = secondLine;
        }

        public int getDrawable() {
            return drawable;
        }

        public void setDrawable(int drawable) {
            this.drawable = drawable;
        }

        public String getFirstLine() {
            return firstLine;
        }

        public void setFirstLine(String firstLine) {
            this.firstLine = firstLine;
        }

        public String getSecondLine() {
            return secondLine;
        }

        public void setSecondLine(String secondLine) {
            this.secondLine = secondLine;
        }

    }


