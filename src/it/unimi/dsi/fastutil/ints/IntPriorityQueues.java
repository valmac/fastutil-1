/* Generic definitions */




/* Assertions (useful to generate conditional code) */
/* Current type and class (and size, if applicable) */
/* Value methods */
/* Interfaces (keys) */
/* Interfaces (values) */
/* Abstract implementations (keys) */
/* Abstract implementations (values) */
/* Static containers (keys) */
/* Static containers (values) */
/* Implementations */
/* Synchronized wrappers */
/* Unmodifiable wrappers */
/* Other wrappers */
/* Methods (keys) */
/* Methods (values) */
/* Methods (keys/values) */
/* Methods that have special names depending on keys (but the special names depend on values) */
/* Equality */
/* Object/Reference-only definitions (keys) */
/* Primitive-type-only definitions (keys) */
/* Object/Reference-only definitions (values) */
/*		 
 * Copyright (C) 2003-2013 Sebastiano Vigna 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package it.unimi.dsi.fastutil.ints;
/** A class providing static methods and objects that do useful things with type-specific priority queues.
 *
 * @see it.unimi.dsi.fastutil.PriorityQueue
 */
public class IntPriorityQueues {
 private IntPriorityQueues() {}
 /** A synchronized wrapper class for priority queues. */
 public static class SynchronizedPriorityQueue implements IntPriorityQueue {
  final protected IntPriorityQueue q;
  final protected Object sync;
  protected SynchronizedPriorityQueue( final IntPriorityQueue q, final Object sync ) {
   this.q = q;
   this.sync = sync;
  }
  protected SynchronizedPriorityQueue( final IntPriorityQueue q ) {
   this.q = q;
   this.sync = this;
  }
  public void enqueue( int x ) { synchronized( sync ) { q.enqueue( x ); } }
  public int dequeueInt() { synchronized( sync ) { return q.dequeueInt(); } }
  public int firstInt() { synchronized( sync ) { return q.firstInt(); } }
  public int lastInt() { synchronized( sync ) { return q.lastInt(); } }
  public boolean isEmpty() { synchronized( sync ) { return q.isEmpty(); } }
  public int size() { synchronized( sync ) { return q.size(); } }
  public void clear() { synchronized( sync ) { q.clear(); } }
  public void changed() { synchronized( sync ) { q.changed(); } }
  public IntComparator comparator() { synchronized( sync ) { return q.comparator(); } }
  public void enqueue( Integer x ) { synchronized( sync ) { q.enqueue( x ); } }
  public Integer dequeue() { synchronized( sync ) { return q.dequeue(); } }
  public Integer first() { synchronized( sync ) { return q.first(); } }
  public Integer last() { synchronized( sync ) { return q.last(); } }
 }
 /** Returns a synchronized type-specific priority queue backed by the specified type-specific priority queue.
	 *
	 * @param q the priority queue to be wrapped in a synchronized priority queue.
	 * @return a synchronized view of the specified priority queue.
	 */
 public static IntPriorityQueue synchronize( final IntPriorityQueue q ) { return new SynchronizedPriorityQueue( q ); }
 /** Returns a synchronized type-specific priority queue backed by the specified type-specific priority queue, using an assigned object to synchronize.
	 *
	 * @param q the priority queue to be wrapped in a synchronized priority queue.
	 * @param sync an object that will be used to synchronize the access to the priority queue.
	 * @return a synchronized view of the specified priority queue.
	 */
 public static IntPriorityQueue synchronize( final IntPriorityQueue q, final Object sync ) { return new SynchronizedPriorityQueue( q, sync ); }
}
