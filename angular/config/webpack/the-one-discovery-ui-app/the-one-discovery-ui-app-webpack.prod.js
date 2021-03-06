var webpack = require('webpack');
var helpers = require('../../helpers');
const { merge } = require('webpack-merge');
var htmlWebpackPlugin = require('html-webpack-plugin');
var miniCssExtractPlugin = require('mini-css-extract-plugin');
var commonConfig = require('./the-one-discovery-ui-app-webpack.common');
var aotPlugin = require('@ngtools/webpack').AngularCompilerPlugin;

const ENV = process.env.NODE_ENV = process.env.ENV = 'production';

module.exports = merge(commonConfig, {
    mode: 'production',

    output: {
        path: helpers.root('dist/dist-the-one-discovery-ui/public'),
        publicPath: '/public/', // path to public on server
        filename: '[name].[hash].js',
        chunkFilename: '[id].[hash].chunk.js'
    },

    module: {
        rules: [
            {
                test: /(?:\.ngfactory\.js|\.ngstyle\.js|\.ts|\.d\.ts)$/,
                loader: '@ngtools/webpack',
                include: [
                    helpers.root('projects/the-one-discovery-ui-app/src/'),
                    helpers.root('projects/the-one-core/')
                ]
            },
            {
                test: /\.scss$/,
                include: [
                    helpers.root('projects/the-one-discovery-ui-app/src/styles.scss')
                ],
                use: [
                    'to-string-loader',
                    'style-loader',
                    'css-loader',
                    'sass-loader',
                    {
                        loader: 'sass-resources-loader',
                        options: {
                            resources: [
                                './assets/scss/_vars.scss',
                                './assets/scss/_mixins.scss'
                            ]
                        }
                    }
                ]
            },
            {
                test: /\.scss$/,
                include: [
                    helpers.root('projects/the-one-discovery-ui-app/src'),
                    helpers.root('assets/scss')
                ],
                exclude: [
                    helpers.root('projects/the-one-discovery-ui-app/src/styles.scss')
                ],
                use: [
                    'raw-loader',
                    'sass-loader',
                    {
                        loader: 'sass-resources-loader',
                        options: {
                            resources: [
                                './assets/scss/_vars.scss',
                                './assets/scss/_mixins.scss'
                            ]
                        }
                    }
                ]
            },
        ]
    },

    optimization: {
        emitOnErrors: false
    },

    plugins: [
        new htmlWebpackPlugin({
            template: helpers.root('projects/the-one-discovery-ui-app/src/index.html'),
            base_path: '' // your application base path from production url
        }),
        new aotPlugin({
            tsConfigPath: 'projects/the-one-discovery-ui-app/tsconfig.app.json',
            entryModule: 'projects/the-one-discovery-ui-app/src/app/app.module#AppModule'
        }),
        new webpack.LoaderOptionsPlugin({
            htmlLoader: {
                minimize: true
            }
        }),
        new webpack.DefinePlugin({
            'process.env': {
                'ENV': JSON.stringify(ENV),
                // API_URL and PUBLIC_URL should be the same, it should be base path to your application
                // in example: if your server url is http://www.example.com
                // and app on that server is http://www.example.com/the-one-discovery-ui-app/
                // the both this values will be /second-example-app/
                'API_URL': JSON.stringify(''),
                'PUBLIC_URL': JSON.stringify('')
            }
        }),
    ]
});
