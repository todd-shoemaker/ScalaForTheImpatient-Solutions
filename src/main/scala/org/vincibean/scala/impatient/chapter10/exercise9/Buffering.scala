/*
 * Copyright (C) 2016  Vincibean <Andre Bessi>
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
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.vincibean.scala.impatient.chapter10.exercise9

import java.io.{BufferedInputStream, InputStream}

/**
  * Using the logger traits from this chapter, add logging to the solution of
  * the preceding problem that demonstrates buffering.
  *
  * Created by Vincibean on 14/03/16.
  */
trait Buffering extends ConsoleLogger with TimestampLogger with ShortLogger {
  this: InputStream =>

  val buffering = new BufferedInputStream(this)

  override def read(b: Array[Byte]): Int = {
    log("Buffering...")
    buffering.read(b)
  }

}