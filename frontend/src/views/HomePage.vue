<template>
  <div class="font-sans text-gray-800">
    <!-- Hero / Banner Section -->
    <section class="bg-gradient-to-r from-blue-500 to-indigo-600 text-white py-20 px-6">
      <div class="container mx-auto text-center">
        <h1 class="text-4xl md:text-5xl font-bold mb-4">Learn Anything, Anytime</h1>
        <p class="mb-6 text-lg md:text-xl">Explore thousands of courses online from expert instructors.</p>
        <div class="flex justify-center space-x-4 mb-6">
          <input type="text" placeholder="Search courses..." class="px-4 py-2 rounded-l-lg w-64 focus:outline-none"/>
          <button class="bg-white text-blue-600 font-bold px-6 rounded-r-lg hover:bg-gray-100 transition">Search</button>
        </div>
        <div class="space-x-4">
          <button class="bg-white text-blue-600 font-bold px-6 py-2 rounded-lg hover:bg-gray-100 transition">Explore Courses</button>
          <button class="bg-blue-800 text-white font-bold px-6 py-2 rounded-lg hover:bg-blue-900 transition">Start Learning</button>
        </div>
      </div>
    </section>

    <!-- Popular Categories -->
    <section class="py-20 px-6">
      <div class="container mx-auto text-center mb-10">
        <h2 class="text-3xl font-bold mb-4">Popular Categories</h2>
        <p class="text-gray-600">Explore courses by categories</p>
      </div>
      <div class="grid grid-cols-2 md:grid-cols-4 gap-6 container mx-auto">
        <div v-for="category in categories" :key="category.name" class="bg-white shadow-lg rounded-lg p-6 hover:shadow-xl transition">
          <img :src="category.image" alt="" class="w-16 h-16 mx-auto mb-4"/>
          <h3 class="font-bold text-lg">{{ category.name }}</h3>
          <p class="text-gray-500">{{ category.courses }} Courses</p>
        </div>
      </div>
    </section>

    <!-- Trending Courses -->
    <section class="bg-gray-100 py-20 px-6">
      <div class="container mx-auto text-center mb-10">
        <h2 class="text-3xl font-bold mb-4">Trending Courses</h2>
        <p class="text-gray-600">Most popular courses among students</p>
      </div>
      <div class="grid grid-cols-1 md:grid-cols-3 gap-6 container mx-auto">
        <div v-for="course in courses" :key="course.title" class="bg-white shadow-lg rounded-lg p-6 hover:shadow-xl transition">
          <img :src="course.image" alt="" class="w-full h-40 object-cover rounded-lg mb-4"/>
          <h3 class="font-bold text-lg mb-1">{{ course.title }}</h3>
          <p class="text-gray-500 mb-2">Instructor: {{ course.instructor }}</p>
          <div class="flex items-center justify-between mb-2">
            <span class="text-yellow-500">⭐ {{ course.rating }}</span>
            <span class="text-green-600 font-bold">{{ course.price }}</span>
          </div>
          <button class="bg-blue-600 text-white w-full py-2 rounded-lg hover:bg-blue-700 transition">Enroll Now</button>
        </div>
      </div>
    </section>

    <!-- Why Choose Us -->
    <section class="py-20 px-6">
      <div class="container mx-auto text-center mb-10">
        <h2 class="text-3xl font-bold mb-4">Why Choose Us</h2>
        <p class="text-gray-600">Learn from the best with flexible and lifetime access</p>
      </div>
      <div class="grid grid-cols-1 md:grid-cols-4 gap-6 container mx-auto text-center">
        <div v-for="benefit in benefits" :key="benefit.title" class="p-6 bg-white shadow-lg rounded-lg hover:shadow-xl transition">
          <img :src="benefit.icon" alt="" class="w-12 h-12 mx-auto mb-4"/>
          <h3 class="font-bold text-lg mb-2">{{ benefit.title }}</h3>
          <p class="text-gray-500">{{ benefit.description }}</p>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
export default {
  name: "HomePage",
  data() {
    return {
      categories: [
        { name: "Web Development", courses: 120, image: "https://images.unsplash.com/photo-1581091012184-6c3508d79d2f?auto=format&fit=crop&w=80&q=80" },
        { name: "Data Science", courses: 85, image: "https://images.unsplash.com/photo-1517430816045-df4b7de11d1f?auto=format&fit=crop&w=80&q=80" },
        { name: "Design", courses: 60, image: "https://images.unsplash.com/photo-1509228627152-0e04d62f5e0f?auto=format&fit=crop&w=80&q=80" },
        { name: "Marketing", courses: 45, image: "https://images.unsplash.com/photo-1504384308090-c894fdcc538d?auto=format&fit=crop&w=80&q=80" }
      ],
      courses: [
        { title: "Vue.js for Beginners", instructor: "John Doe", rating: 4.8, price: "Free", image: "https://images.unsplash.com/photo-1581091012184-6c3508d79d2f?auto=format&fit=crop&w=400&q=80" },
        { title: "React Advanced", instructor: "Jane Smith", rating: 4.7, price: "$19", image: "https://images.unsplash.com/photo-1590608897129-79a06e3dcfa2?auto=format&fit=crop&w=400&q=80" },
        { title: "Data Science with Python", instructor: "Alice Brown", rating: 4.9, price: "$29", image: "https://images.unsplash.com/photo-1590608897129-79a06e3dcfa2?auto=format&fit=crop&w=400&q=80" }
      ],
      benefits: [
        { title: "Expert Instructors", description: "Learn from industry experts", icon: "https://img.icons8.com/color/48/000000/teacher.png" },
        { title: "Lifetime Access", description: "Access courses anytime", icon: "https://img.icons8.com/color/48/000000/infinity.png" },
        { title: "Certificates", description: "Get recognized certificates", icon: "https://img.icons8.com/color/48/000000/certificate.png" },
        { title: "Flexible Learning", description: "Learn at your own pace", icon: "https://img.icons8.com/color/48/000000/flexible.png" }
      ]
    };
  }
};
</script>

<style scoped>
.container { max-width: 1200px; }
</style>
