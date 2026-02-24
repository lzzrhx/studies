import { defineConfig } from 'vite'

export default defineConfig({
  //base: './,
  root: 'src',
  publicDir: 'glb',
  build: { outDir: '../dist', },
  server: { host: true, },
})
