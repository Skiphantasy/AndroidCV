/**
 * Author: Skipha
 * Date: 26 Oct 2018
 */

package com.skipha.cv;

import java.io.Serializable;

public class Work implements Serializable
{
        private String role;
        private String date;

        public Work(String role, String date) {
            this.role = role;
            this.date = date;
        }

        public String getRole() {
            return role;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

    }
