var webpack = require('webpack');
var helpers = require('../../helpers');
var miniCssExtractPlugin = require('mini-css-extract-plugin');

/**
 * This is common part of webpack config, used both in development and production
 **/
module.exports = {
    entry: {
        polyfills: './projects/the-one-ui-app/src/polyfills.ts',
        vendor: './projects/the-one-ui-app/src/vendor.ts',
        app: './projects/the-one-ui-app/src/main.ts'
    },

    resolve: {
        extensions: ['.js', '.ts', '.css', '.scss'],
        symlinks: false
    },

    module: {
        rules: [
            {
                test: /\.html$/,
                include: [
                    helpers.root('projects/the-one-ui-app/src')
                ],
                use: [
                    {
                        loader: 'html-loader',
                        options: {
                            esModule: false,
                        }
                    }
                ]
            },
            {
                test: /\.(png|jpe?g|gif|svg|woff|woff2|tf|eot|ico)$/,
                use: [
                    {
                        loader: 'file-loader',
                        options: {
                            name: "./assets/[name].[hash].[ext]"
                        }
                    },
                ]
            },
            {
                test: /\.css$/,
                exclude: [
                    helpers.root('projects/the-one-ui-app/src')
                ],
                use: [
                    miniCssExtractPlugin.loader,
                    'css-loader'
                ]
            },
            {
                test: /\.css$/,
                include: [
                    helpers.root('projects/the-one-ui-app/src')
                ],
                loader: 'raw-loader'
            }
        ]
    },

    optimization: {
        splitChunks: {
            cacheGroups: {
                vendors: {
                    test: /[\\/]node_modules[\\/]/,
                    name: 'vendors',
                    chunks: 'all'
                },
                polyfills: {
                    test: /[\\/]polyfills[\\/]/,
                    name: 'polyfills',
                    chunks: 'all'
                },
            }
        }
    },

    plugins: [
        new webpack.ProvidePlugin({
            jQuery: 'jquery',
            $: 'jquery',
            jquery: 'jquery'
        }),
        new webpack.ContextReplacementPlugin(
            /(.+)?angular(\\|\/)core(.+)?/,
            helpers.root('projects/the-one-ui-app/src/app')
        ),
        new miniCssExtractPlugin(),
        new webpack.LoaderOptionsPlugin({
            options: {
                packages: {
                    moment: {
                        map: 'node_modules/moment/moment.js',
                        type: 'cjs',
                        defaultExtension: 'js'
                    }
                }
            }
        })
    ]
};
