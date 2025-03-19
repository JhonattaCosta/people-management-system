import { defineConfig, loadEnv } from 'vite';
import react from '@vitejs/plugin-react';

export default defineConfig(({ mode }) => {
    // "Load the environment variables from the .env file.
    const env = loadEnv(mode, process.cwd(), '');

    return {
        plugins: [react()],
        server: {
            proxy: {
                '/api': {
                    target: env.VITE_API_URL, // Use the environment variable for the target.
                    changeOrigin: true,
                },
            },
        },
        build: {
            outDir: env.VITE_OUT_DIR, // Use the environment variable for the outDir.
            emptyOutDir: true,
        },
    };
});