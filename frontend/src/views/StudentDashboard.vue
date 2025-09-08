<template>
  <div class="flex h-screen bg-gray-100">
    <!-- Sidebar / Navigation Menu -->
    <aside class="w-64 bg-white shadow-lg">
      <div class="p-6 text-center font-bold text-xl border-b">
        SmartLearning
      </div>
      <nav class="mt-6">
        <ul>
          <li class="px-6 py-3 hover:bg-gray-200 cursor-pointer rounded">
            Dashboard
          </li>
          <li class="px-6 py-3 hover:bg-gray-200 cursor-pointer rounded">
            My Courses
          </li>
          <li class="px-6 py-3 hover:bg-gray-200 cursor-pointer rounded">
            Wishlist
          </li>
          <li class="px-6 py-3 hover:bg-gray-200 cursor-pointer rounded">
            Certificates
          </li>
          <li class="px-6 py-3 hover:bg-gray-200 cursor-pointer rounded">
            Account Settings
          </li>
          <li class="px-6 py-3 hover:bg-gray-200 cursor-pointer rounded">
            Support / Help
          </li>
        </ul>
      </nav>
    </aside>

    <!-- Main Content -->
    <main class="flex-1 overflow-y-auto p-6">
      <!-- Welcome / Greeting Banner -->
      <section class="bg-blue-500 text-white p-6 rounded-lg mb-6 shadow">
        <h1 class="text-2xl font-bold">Hi, {{ studentName }}!</h1>
        <p class="mt-2">
          You have {{ totalCourses }} courses enrolled,
          {{ completedCourses }} completed, and {{ hoursLearned }} hours
          learned.
        </p>
        <p class="mt-2 italic text-sm">
          Keep up the great work! Your next lesson awaits.
        </p>
      </section>

      <!-- Course Overview / My Courses Section -->
      <section class="mb-6">
        <h2 class="text-xl font-semibold mb-4">My Courses</h2>
        <div class="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6">
          <div
            v-for="course in enrolledCourses"
            :key="course.id"
            class="bg-white rounded-lg shadow p-4"
          >
            <img
              :src="course.image"
              alt="Course Image"
              class="h-40 w-full object-cover rounded-md mb-2"
            />
            <h3 class="font-semibold text-lg">{{ course.title }}</h3>
            <p class="text-gray-500 text-sm">
              Last accessed: {{ course.lastAccessed }}
            </p>
            <div class="w-full bg-gray-200 h-2 rounded mt-2">
              <div
                class="bg-blue-500 h-2 rounded"
                :style="{ width: course.progress + '%' }"
              ></div>
            </div>
            <button
              class="mt-2 w-full bg-blue-500 text-white py-2 rounded hover:bg-blue-600"
            >
              Continue
            </button>
          </div>
        </div>
      </section>

      <!-- Recommended Courses -->
      <section class="mb-6">
        <h2 class="text-xl font-semibold mb-4">Recommended for You</h2>
        <div class="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6">
          <div
            v-for="course in recommendedCourses"
            :key="course.id"
            class="bg-white rounded-lg shadow p-4"
          >
            <img
              :src="course.image"
              alt="Course Image"
              class="h-40 w-full object-cover rounded-md mb-2"
            />
            <h3 class="font-semibold text-lg">{{ course.title }}</h3>
            <p class="text-gray-500 text-sm">{{ course.description }}</p>
            <p class="text-yellow-500 mt-1">
              ⭐ {{ course.rating }} ({{ course.students }} students)
            </p>
          </div>
        </div>
      </section>

      <!-- Progress / Learning Stats -->
      <section class="mb-6 bg-white p-4 rounded-lg shadow">
        <h2 class="text-xl font-semibold mb-4">Learning Stats</h2>
        <div class="grid grid-cols-1 sm:grid-cols-2 gap-4">
          <div>
            <p>Overall Completion</p>
            <div class="w-full bg-gray-200 h-4 rounded">
              <div
                class="bg-green-500 h-4 rounded"
                :style="{ width: overallCompletion + '%' }"
              ></div>
            </div>
          </div>
          <div>
            <p>Courses Completed per Month</p>
            <!-- Example: Simple Bar Chart -->
            <div class="grid grid-cols-6 gap-1 mt-2 h-24 items-end">
              <div
                v-for="(count, month) in coursesPerMonth"
                :key="month"
                class="bg-blue-500"
                :style="{ height: count * 10 + 'px' }"
              ></div>
            </div>
          </div>
        </div>
      </section>

      <!-- Notifications -->
      <section class="mb-6 bg-white p-4 rounded-lg shadow">
        <h2 class="text-xl font-semibold mb-4">Notifications</h2>
        <ul>
          <li
            v-for="note in notifications"
            :key="note.id"
            class="border-b py-2"
          >
            {{ note.message }}
            <span class="text-gray-400 text-sm">({{ note.time }})</span>
          </li>
        </ul>
      </section>

      <!-- Recent Activity -->
      <section class="mb-6 bg-white p-4 rounded-lg shadow">
        <h2 class="text-xl font-semibold mb-4">Recent Activity</h2>
        <ul>
          <li
            v-for="activity in recentActivity"
            :key="activity.id"
            class="border-b py-2"
          >
            {{ activity.description }}
            <span class="text-gray-400 text-sm">({{ activity.time }})</span>
          </li>
        </ul>
      </section>

      <!-- Certificates / Achievements -->
      <section class="mb-6 bg-white p-4 rounded-lg shadow">
        <h2 class="text-xl font-semibold mb-4">Certificates & Achievements</h2>
        <div class="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-4">
          <div
            v-for="cert in certificates"
            :key="cert.id"
            class="bg-gray-100 rounded-lg p-4 text-center"
          >
            <img
              :src="cert.image"
              alt="Certificate"
              class="h-32 w-full object-cover rounded mb-2"
            />
            <p class="font-semibold">{{ cert.title }}</p>
            <button
              class="mt-2 bg-blue-500 text-white py-1 px-4 rounded hover:bg-blue-600"
            >
              Download
            </button>
          </div>
        </div>
      </section>
    </main>
  </div>
</template>

<script>
export default {
  name: "StudentDashboard",
  data() {
    return {
      studentName: "John Doe",
      totalCourses: 5,
      completedCourses: 2,
      hoursLearned: 42,
      overallCompletion: 40,
      enrolledCourses: [
        {
          id: 1,
          title: "Vue.js Basics",
          progress: 40,
          lastAccessed: "2025-09-01",
          image:
            "https://images.unsplash.com/photo-1581091215366-2a5b5a89e95c?auto=format&fit=crop&w=500&q=60",
        },
        {
          id: 2,
          title: "JavaScript Advanced",
          progress: 60,
          lastAccessed: "2025-09-05",
          image:
            "https://images.unsplash.com/photo-1517433456452-f9633a875f6f?auto=format&fit=crop&w=500&q=60",
        },
      ],
      recommendedCourses: [
        {
          id: 1,
          title: "React for Beginners",
          rating: 4.5,
          students: 1200,
          description: "Learn React from scratch.",
          image:
            "https://images.unsplash.com/photo-1581091215366-2a5b5a89e95c?auto=format&fit=crop&w=500&q=60",
        },
        {
          id: 2,
          title: "Node.js Essentials",
          rating: 4.2,
          students: 800,
          description: "Backend development with Node.js.",
          image:
            "https://images.unsplash.com/photo-1517433456452-f9633a875f6f?auto=format&fit=crop&w=500&q=60",
        },
      ],
      coursesPerMonth: [2, 3, 1, 4, 2, 3],
      notifications: [
        {
          id: 1,
          message: "New lesson released in Vue.js Basics",
          time: "2h ago",
        },
        { id: 2, message: "Assignment deadline approaching", time: "1d ago" },
      ],
      recentActivity: [
        {
          id: 1,
          description: "Completed lesson 3 in Vue.js Basics",
          time: "3h ago",
        },
        {
          id: 2,
          description: "Started lesson 2 in JavaScript Advanced",
          time: "1d ago",
        },
      ],
      certificates: [
        {
          id: 1,
          title: "Vue.js Basics Certificate",
          image:
            "https://images.unsplash.com/photo-1605902711622-cfb43c443f6d?auto=format&fit=crop&w=500&q=60",
        },
        {
          id: 2,
          title: "JavaScript Advanced Certificate",
          image:
            "https://images.unsplash.com/photo-1517433456452-f9633a875f6f?auto=format&fit=crop&w=500&q=60",
        },
      ],
    };
  },
};
</script>

<style>
/* Optional: scrollbar styling for main content */
main::-webkit-scrollbar {
  width: 8px;
}
main::-webkit-scrollbar-thumb {
  background-color: rgba(0, 0, 0, 0.2);
  border-radius: 4px;
}
</style>
