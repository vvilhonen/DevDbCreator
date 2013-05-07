Vagrant::Config.run do |config|
  config.vm.box = "precise64"
  config.vm.box_url = "http://files.vagrantup.com/precise64.box"
  config.vm.network :hostonly, "10.11.15.5"
  config.vm.provision :chef_solo do |c|
    c.cookbooks_path = "chef/cookbooks"
    c.add_recipe 'apt'
    c.add_recipe 'mysql::client'
    c.add_recipe 'mysql::ruby'
    c.add_recipe 'mysql::server'
    c.json.merge!({
      :apt => { :mirror => :fi },
      :mysql => {
        :bind_address => "0.0.0.0",
        :server_root_password => "foo",
        :server_debian_password => "foo",
        :server_repl_password => "foo",
        :root_network_acl => "%",
        :allow_remote_root => true
      }
    })
  end
end

