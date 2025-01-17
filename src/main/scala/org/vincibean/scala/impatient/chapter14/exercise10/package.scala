/*
 * Copyright (C) 2017  Vincibean <Andrea Bessi>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.vincibean.scala.impatient.chapter14

/**
  * Write a function that composes two functions of type Double => Option[Double],
  * yielding another function of the same type. The composition should yield
  * None if either function does. For example,
  *
  *   def f(x: Double) = if (x >= 0) Some(sqrt(Double)) else None
  *   def g(x: Double) = if (x != 1) Some(1 / (x - 1)) else None
  *   val h = compose(f, g)
  *
  * Then h(2) is Some(1), and h(1) and h(0) are None.
  */
package object exercise10 {

// h(2) returns Some(1), h(1) returns None, but h(0) returns -1.0 instead of None
//   def compose(f: Double => Option[Double], g: Double => Option[Double]): Double => Option[Double] = d =>
//     (f(d), g(d)) match {
//       case (Some(_), b @ Some(_)) => b
//       case _ => None
//     }
 
def compose(f: Double => Option[Double], g: Double => Option[Double]): (Double) => Option[Double] = (x: Double) => {
    g(x) match {
        case Some(a) => f(a) 
        case _ => None
    }
}
 
// Alternate version using the 'val function' syntax to declare a local function and return it. 
def compose2(f: Double => Option[Double], g: Double => Option[Double]): (Double) => Option[Double] = {
    // This is the syntax to explicitly declare the return type of a 'val function'.  The full function
    // type declaration occurs between the : and the =.
    val h: (Double) => Option[Double] = (x: Double) =>  {
        g(x) match {
            case Some(a) => f(a) 
            case _ => None
        }
    }
    h // return the function 
}

 
 


}
